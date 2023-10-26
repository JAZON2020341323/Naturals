package com.example.naturals.formCadastro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.naturals.Activity.activity.MainActivity;
import com.example.naturals.R;
import com.example.naturals.modelo_de_dados.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TeladeCadastro extends AppCompatActivity {




    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextSenha;
    private Button buttonCadastrar;
    private FirebaseAuth mAuth;
    private Usuario u;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telade_cadastro);
        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);
        mAuth = FirebaseAuth.getInstance();

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recuperarDados();
                criarLogin();
            }
        });

    }

    private void criarLogin() {
        mAuth.createUserWithEmailAndPassword(u.getEmail(),u.getSenha())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser user = mAuth.getCurrentUser();
                            u.setId(user.getUid());
                            u.salvarDados();
                            startActivity(new Intent(TeladeCadastro.this, MainActivity.class));

                        }else{
                            Toast.makeText(TeladeCadastro.this,"Error ao criar um login",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void recuperarDados() {
        if (editTextNome.getText().toString()==""||editTextEmail.getText().toString()==""||editTextSenha.getText().toString()==""){
            Toast.makeText(this,"Você deve preencher todos os dados",Toast.LENGTH_LONG);
        }else{
            u = new Usuario();
            u.setNome(editTextNome.getText().toString());
            u.setEmail(editTextEmail.getText().toString());
            u.setSenha(editTextSenha.getText().toString());


        }

    }

}

