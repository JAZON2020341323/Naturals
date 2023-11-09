package com.example.naturals.TelasdeEndereco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.naturals.Activity.activities.ActivityPagamento;
import com.example.naturals.R;

public class ActivityEndereco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);


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
            Intent in = new Intent(ActivityEndereco.this, AdicionarEndereco.class);
            startActivity(in);
        }

}