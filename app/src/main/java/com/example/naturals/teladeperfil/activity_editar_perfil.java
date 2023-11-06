package com.example.naturals.teladeperfil;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.naturals.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.io.IOException;
import java.io.InputStream;

public class activity_editar_perfil extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imgPerfil;
    private EditText txtNome, txtEmail, txtSenha;
    private Button btnConfirmar;
    private Uri selectedImageUri;
    private FirebaseAuth auth;
    String usuarioID;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        imgPerfil = findViewById(R.id.imgPerfil);
        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        auth = FirebaseAuth.getInstance();

        imgPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfileChanges();
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
                imgPerfil.setImageBitmap(getCircularBitmap(bitmap));
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

    private void saveProfileChanges() {
        final String newName = txtNome.getText().toString().trim();
        final String newEmail = txtEmail.getText().toString().trim();
        final String newPassword = txtSenha.getText().toString().trim();

        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            if (selectedImageUri != null) {
                // Faça o upload da nova imagem de perfil para o Firebase Storage e atualize a URL da imagem de perfil no perfil do usuário.
                // Você precisará implementar esta parte separadamente.
            }

            if (!TextUtils.isEmpty(newName)) {
                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                        .setDisplayName(newName)
                        .build();
                user.updateProfile(profileUpdates);
            }

            if (!TextUtils.isEmpty(newEmail)) {
                user.updateEmail(newEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // Atualização bem-sucedida, exiba uma mensagem de sucesso.
                            Toast.makeText(activity_editar_perfil.this, "Email atualizado com sucesso.", Toast.LENGTH_SHORT).show();
                        } else {
                            // Se a atualização falhar, exiba uma mensagem de erro.
                            Toast.makeText(activity_editar_perfil.this, "Erro ao atualizar o email.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            if (!TextUtils.isEmpty(newPassword)) {
                user.updatePassword(newPassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // Senha atualizada com sucesso.
                            Toast.makeText(activity_editar_perfil.this, "Senha atualizada com sucesso.", Toast.LENGTH_SHORT).show();
                        } else {
                            // Se a atualização da senha falhar, exiba uma mensagem de erro.
                            Toast.makeText(activity_editar_perfil.this, "Erro ao atualizar a senha.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
    }







    @Override
    protected void onStart() {
        super.onStart();

        String email =FirebaseAuth.getInstance().getCurrentUser().getEmail();
        String senha =FirebaseAuth.getInstance().getCurrentUser().getUid();
        usuarioID=FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("usuario").document(usuarioID);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {

                if (documentSnapshot != null){
                    txtNome.setText(documentSnapshot.getString("nome"));
                    txtNome.setText(documentSnapshot.getString("nome"));
                   txtEmail.setText(email);
                   txtSenha.setText(senha);
                }
            }
        });

    }
}
