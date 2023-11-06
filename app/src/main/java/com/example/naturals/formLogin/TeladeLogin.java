package com.example.naturals.formLogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.naturals.Activity.activities.MainActivity;
import com.example.naturals.R;
import com.example.naturals.formCadastro.ActivityCadastro;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TeladeLogin extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextSenha;
    private Button button_entrar;
    private ProgressBar progressBar2;
    private FirebaseAuth auth;
    private Button btnResetsenha;

    private Button button_aindanaoeusuario;
    String[] mensagens = {"Preencha todos os campos!", "Login Efetuado com sucesso"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telade_login);

        IniciarComponentes();

        btnResetsenha = findViewById(R.id.btnResetsenha);

        auth = FirebaseAuth.getInstance();

        btnResetsenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alterarSenha();
            }
        });



        button_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();

                if (email.isEmpty() || senha.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {

                    AutenticarUsuario(v);
                }

            }
        });

    }

    private void alterarSenha() {
        String email = editTextEmail.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(TeladeLogin.this, "Por favor, insira seu e-mail", Toast.LENGTH_SHORT).show();
            return;
        }

        // Envia um e-mail de redefinição de senha
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(TeladeLogin.this, "Um e-mail de redefinição de senha foi enviado para o seu endereço de e-mail.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(TeladeLogin.this, "Erro ao enviar o e-mail. Verifique seu endereço de e-mail.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    private void AutenticarUsuario(View view){

        String email = editTextEmail.getText().toString();
        String senha = editTextSenha.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    progressBar2.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            TelaPrincipal();

                        }
                    },3000);
                }else {
                    String erro;

                    try {
                        throw task.getException();
                    }catch (Exception e){
                        erro = "Erro ao logar, E-mail ou Senha inválido";
                    }
                    Snackbar snackbar = Snackbar.make(view,erro, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser usuarioAtual = FirebaseAuth.getInstance().getCurrentUser();

        if (usuarioAtual != null){
            TelaPrincipal();
        }
    }

    private void TelaPrincipal(){
        Intent intent = new Intent(TeladeLogin.this,MainActivity.class);
        startActivity(intent);
        finish();
    }



    private void IniciarComponentes(){
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        button_entrar = findViewById(R.id.button_entrar);
        progressBar2 = findViewById(R.id.progressBar2);

    }


    public void AindaNaoEUsuario(View view) {
        Intent in = new Intent(TeladeLogin.this, ActivityCadastro.class);
        startActivity(in);
    }


}