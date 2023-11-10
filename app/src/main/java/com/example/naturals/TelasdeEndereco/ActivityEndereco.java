package com.example.naturals.TelasdeEndereco;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.naturals.Activity.activities.ActivityCarrinho;
import com.example.naturals.Activity.activities.ActivityPagamento;
import com.example.naturals.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class ActivityEndereco extends AppCompatActivity {

    private TextView textViewnome, textViewendereco, textViewEstado, textViewCidade, textViewcep, textViewtelefone;
    private Button btnEnviarEndereco;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);



    }





    public void Voltando_carrinho (View view) {
        Intent in = new Intent(ActivityEndereco.this, ActivityCarrinho.class);
        startActivity(in);
    }

        public void btn_enviar_endereco (View view){
            Intent in = new Intent(ActivityEndereco.this, ActivityPagamento.class);
            startActivity(in);
        }
        public void btn_editar_endereco (View view){
            Intent in = new Intent(ActivityEndereco.this, EditarEndereco.class);
            startActivity(in);
        }
        public void btn_adicionar_endereco (View view){
            Intent in = new Intent(ActivityEndereco.this, CadastrarEndereco.class);
            startActivity(in);
        }

}