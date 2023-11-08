package com.example.naturals.teladeperfil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.naturals.R;
import com.example.naturals.TelasdeEndereco.EditarEndereco;
import com.example.naturals.formLogin.TeladeLogin;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.UploadTask;

import android.content.Intent;
import android.content.SharedPreferences;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class activity_telade_perfil extends AppCompatActivity {

    private TextView nome_usuario, nomeusuario, email_usuario, senha_usuario;
    private Button bt_deslogar;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioID;
    private Uri selectedImageUri;

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imgFotoPerfil;
    private ImageView btnEdndereco;

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

        bt_deslogar = findViewById(R.id.bt_deslogar);
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
                // Atualize o campo da imagem de perfil no Firebase Firestore
                saveImageURLToDatabase(selectedImageUri.toString()); // Corrigido aqui
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

// ...



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

        int size = Math.min(width, height);
        int x = (width - size) / 2;
        int y = (height - size) / 2;

        Bitmap croppedBitmap = Bitmap.createBitmap(srcBitmap, x, y, size, size);
        if (croppedBitmap != srcBitmap) {
            srcBitmap.recycle(); // Liberar a memória da imagem original
        }

        Bitmap outputBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(outputBitmap);
        BitmapShader shader = new BitmapShader(croppedBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);

        Paint paint = new Paint();
        paint.setShader(shader);
        paint.setAntiAlias(true);

        float radius = size / 2f;
        canvas.drawCircle(radius, radius, radius, paint);

        return outputBitmap;
    }

    private void uploadImageToFirebaseStorage(Uri imageUri) {
        if (imageUri != null) {
            String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
            final StorageReference imageRef = storageRef.child("profile_images/" + userId + ".jpg");

            // Verifique se a imagem anterior existe e exclua-a
            imageRef.getDownloadUrl().addOnSuccessListener(downloadUri -> {
                // Se a URL da imagem anterior existir, exclua-a
                String previousImageUrl = downloadUri.toString();
                if (!previousImageUrl.isEmpty()) {
                    // Exclua a imagem anterior
                    FirebaseStorage.getInstance().getReferenceFromUrl(previousImageUrl).delete()
                            .addOnSuccessListener(aVoid -> {
                                // Após a exclusão bem-sucedida da imagem anterior, faça o upload da nova imagem
                                UploadTask uploadTask = imageRef.putFile(imageUri);
                                uploadTask.addOnSuccessListener(taskSnapshot -> {
                                    // Imagem carregada com sucesso, obtenha a URL da nova imagem
                                    imageRef.getDownloadUrl().addOnSuccessListener(newOnSuccessListener -> {
                                        // Salve a URL da nova imagem no banco de dados do Firebase
                                        String newImageUrl = newOnSuccessListener.toString();
                                        saveImageURLToDatabase(newImageUrl);
                                    });
                                });
                            });
                } else {
                    // Se não houver uma imagem anterior, faça o upload da nova imagem diretamente
                    UploadTask uploadTask = imageRef.putFile(imageUri);
                    uploadTask.addOnSuccessListener(taskSnapshot -> {
                        // Imagem carregada com sucesso, obtenha a URL da nova imagem
                        imageRef.getDownloadUrl().addOnSuccessListener(newOnSuccessListener -> {
                            // Salve a URL da nova imagem no banco de dados do Firebase
                            String newImageUrl = newOnSuccessListener.toString();
                            saveImageURLToDatabase(newImageUrl);
                        });
                    });
                }
            });
        }
    }

    private void saveImageURLToDatabase(String imageUrl) {
        // Obtém o UID do usuário atual
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // Atualize o campo da imagem de perfil no banco de dados
        DocumentReference userRef = db.collection("usuario").document(userId);
        userRef.update("profile_images", imageUrl);
    }

    // Salva a imagem localmente
    private void saveImageLocally(Bitmap image) {
        try {
            File outputDir = getApplicationContext().getCacheDir(); // Pasta de cache do aplicativo
            File imageFile = new File(outputDir, "profile_image.jpg");

            FileOutputStream out = new FileOutputStream(imageFile);
            image.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();

            SharedPreferences sharedPreferences = getSharedPreferences("user_profile", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("local_image_path", imageFile.getAbsolutePath());
            editor.apply();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("usuario").document(usuarioID);
        documentReference.addSnapshotListener((documentSnapshot, error) -> {
            if (documentSnapshot != null) {
                nome_usuario.setText(documentSnapshot.getString("nome"));
                email_usuario.setText(email);

                // Obtenha a URL da imagem do perfil do banco de dados
                String imageUrl = documentSnapshot.getString("profile_images");

                if (imageUrl != null) {
                    // Use a biblioteca Glide para carregar a imagem no ImageView
                    Glide.with(this)
                            .load(imageUrl)
                            .placeholder(R.drawable.baseline_add_24)
                            .into(imgFotoPerfil);
                }
            }
        });
    }

    private void IniciarComponentes() {
        nome_usuario = findViewById(R.id.textView_show_full_name);
        email_usuario = findViewById(R.id.textView_show_email);
        bt_deslogar = findViewById(R.id.bt_deslogar);
    }

    public void btnEdndereco(View view){
        Intent in = new Intent(activity_telade_perfil.this, EditarEndereco.class);
        startActivity(in);
    }
}
