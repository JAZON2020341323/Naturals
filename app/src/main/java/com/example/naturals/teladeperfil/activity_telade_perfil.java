package com.example.naturals.teladeperfil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.naturals.R;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.naturals.formLogin.TeladeLogin;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.io.InputStream;

public class activity_telade_perfil extends AppCompatActivity {

    private TextView nome_usuario, nomeusuario, email_usuario, senha_usuario;
    private Button bt_deslogar;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioID;
    private Button bt_editar;
    private Uri selectedImageUri;

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imgFotoPerfil;

    // Declare as referências do Firebase Storage e do Realtime Database
    private FirebaseStorage storage;
    private StorageReference storageRef;
    private DatabaseReference databaseRef;
    private DatabaseReference usersRef; // Referência ao nó de usuários

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telade_perfil);
        imgFotoPerfil = findViewById(R.id.imgFotoPerfil);
        IniciarComponentes();

        // Inicialize as referências do Firebase
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        databaseRef = FirebaseDatabase.getInstance().getReference();
        usersRef = databaseRef.child("usuario"); // Referência ao nó de usuários

        imgFotoPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        });

        bt_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_telade_perfil.this, activity_editar_perfil.class);
                startActivity(intent);
                finish();
            }
        });

        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(activity_telade_perfil.this, TeladeLogin.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void openImagePicker() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Selecionar Imagem de Perfil"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            selectedImageUri = data.getData();

            try {
                // Carregue e ajuste a orientação da imagem
                Bitmap bitmap = handleImageOrientation(selectedImageUri);
                // Redimensiona a imagem para um círculo
                imgFotoPerfil.setImageBitmap(getCircularBitmap(bitmap));
                // Faça o upload da imagem para o Firebase Storage
                uploadImageToFirebaseStorage(selectedImageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Bitmap handleImageOrientation(Uri imageUri) throws IOException {
        InputStream input = getContentResolver().openInputStream(imageUri);
        ExifInterface exif = new ExifInterface(input);

        int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

        int rotationAngle = 0;
        if (orientation == ExifInterface.ORIENTATION_ROTATE_90) {
            rotationAngle = 90;
        } else if (orientation == ExifInterface.ORIENTATION_ROTATE_180) {
            rotationAngle = 180;
        } else if (orientation == ExifInterface.ORIENTATION_ROTATE_270) {
            rotationAngle = 270;
        }

        Bitmap sourceBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
        return rotateBitmap(sourceBitmap, rotationAngle);
    }

    private Bitmap rotateBitmap(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }

    private Bitmap getCircularBitmap(Bitmap srcBitmap) {
        int width = srcBitmap.getWidth();
        int height = srcBitmap.getHeight();
        Bitmap outputBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(outputBitmap);
        BitmapShader shader = new BitmapShader(srcBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(shader);
        paint.setAntiAlias(true);
        float radius = Math.min(width, height) / 2;
        canvas.drawCircle(width / 2, height / 2, radius, paint);
        return outputBitmap;
    }

    private void uploadImageToFirebaseStorage(Uri imageUri) {
        if (imageUri != null) {
            // Defina o nome do arquivo no Firebase Storage (pode ser o UID do usuário)
            String fileName = FirebaseAuth.getInstance().getCurrentUser().getUid() + ".jpg";
            StorageReference imageRef = storageRef.child("profile_images/" + fileName);

            UploadTask uploadTask = imageRef.putFile(imageUri);
            uploadTask.addOnSuccessListener(taskSnapshot -> {
                // Imagem carregada com sucesso, obtenha a URL da imagem
                imageRef.getDownloadUrl().addOnSuccessListener(downloadUri -> {
                    // Salve a URL da imagem no banco de dados do Firebase
                    String imageUrl = downloadUri.toString();
                    saveImageURLToDatabase(imageUrl);
                });
            });
        }
    }

    private void saveImageURLToDatabase(String imageUrl) {
        // Obtém o UID do usuário atual
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // Atualize o campo da imagem de perfil no banco de dados
        usersRef.child(userId).child("imagemPerfil").setValue(imageUrl);
    }

    @Override
    protected void onStart() {
        super.onStart();

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        String senha = FirebaseAuth.getInstance().getCurrentUser().getUid();
        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("usuario").document(usuarioID);
        documentReference.addSnapshotListener((documentSnapshot, error) -> {
            if (documentSnapshot != null) {
                nome_usuario.setText(documentSnapshot.getString("nome"));
                nomeusuario.setText(documentSnapshot.getString("nome"));
                email_usuario.setText(email);
                senha_usuario.setText(senha);
            }
        });
    }

    private void IniciarComponentes() {
        nomeusuario = findViewById(R.id.text_view_show_welcome);
        nome_usuario = findViewById(R.id.textView_show_full_name);
        email_usuario = findViewById(R.id.textView_show_email);
        senha_usuario = findViewById(R.id.textView_show_senha);
        bt_deslogar = findViewById(R.id.bt_deslogar);
        bt_editar = findViewById(R.id.bt_editar);
    }
}
