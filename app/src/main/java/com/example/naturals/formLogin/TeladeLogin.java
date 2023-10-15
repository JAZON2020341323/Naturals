package com.example.naturals.formLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.naturals.R;
import com.example.naturals.formCadastro.TeladeCadastro;
import com.example.naturals.modelo_de_dados.Usuario;
import com.example.naturals.ui.home.HomeLista;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.checkerframework.checker.nullness.qual.NonNull;

public class TeladeLogin extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextSenha;
    private Button button_entrar;
    private FirebaseAuth mAuth;

    private Button button_aindanaoeusuario;
    private Usuario u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telade_login);
        mAuth = FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        button_entrar = findViewById(R.id.button_entrar);





        button_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receberDados();
                logar();



            }
        });


    }

    private void logar() {
        mAuth.signInWithEmailAndPassword(u.getEmail(), u.getSenha())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(TeladeLogin.this, HomeLista.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(TeladeLogin.this, "Autenticação falhou.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void receberDados() {
        u = new Usuario();
        u.setEmail(editTextEmail.getText().toString());
        u.setSenha(editTextSenha.getText().toString());

    }


    public void AindaNaoEUsuario(View view) {
        Intent in = new Intent(TeladeLogin.this, TeladeCadastro.class);
        startActivity(in);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void reload() {
    }
}