package com.example.naturals.teladeperfil.perfil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.naturals.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.naturals.formLogin.TeladeLogin;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class activity_telade_perfil extends AppCompatActivity {

    private TextView nome_usuario, email_usuario, senha_usuario;
    private Button bt_deslogar;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioID, usuario_Senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telade_perfil);

        getSupportActionBar().hide();
        IniciarComponentes();

        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();

                Intent intent= new Intent(activity_telade_perfil.this, TeladeLogin.class);
                startActivity(intent);
                finish();
            }

        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        String email =FirebaseAuth.getInstance().getCurrentUser().getEmail();
        String senha =FirebaseAuth.getInstance().getCurrentUser().getTenantId();
        usuarioID=FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuarios").document(usuarioID);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {

                if (documentSnapshot != null){
                    nome_usuario.setText(documentSnapshot.getString("id"));
                    email_usuario.setText(email);
                    senha_usuario.setText(senha);
                }
            }
        });

    }

    private void IniciarComponentes(){
        nome_usuario = findViewById(R.id.textView_show_full_name);
        email_usuario = findViewById(R.id.textView_show_email);
        senha_usuario = findViewById(R.id.textView_show_senha);
        bt_deslogar = findViewById(R.id.bt_deslogar);


    }

}