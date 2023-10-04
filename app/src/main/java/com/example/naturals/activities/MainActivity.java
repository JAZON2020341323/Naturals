package com.example.naturals.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.naturals.R;
import com.example.naturals.formLogin.TeladeLogin;
import com.example.naturals.ui.home.Tela_Home;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currenteUser = mAuth.getCurrentUser();

        if (currenteUser != null) {
            //Fazer login automatico com o token de autenticação salvo
            Intent intent = new Intent(MainActivity.this, Tela_Home.class);
            startActivity(intent);
            finish();

        }

        SharedPreferences sharedPreferences = getSharedPreferences("LOGIN_PREFS", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email","");
        String senha = sharedPreferences.getString("senha", "");


        FirebaseAuth mAuth1 = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                SharedPreferences sharedPreferences1 = getSharedPreferences("LOGIN_PREFS", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences1.edit();
                editor.putString("email", email);
                editor.putString("senha", senha);
                editor.apply();
                // Login bem-sucedido

            } else {
                Toast.makeText(MainActivity.this, "Falha no login", Toast.LENGTH_SHORT).show();
            }
        });




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), TeladeLogin.class));
                finish();
            }
        }, 5000);
    }
}