package com.example.naturals.TelasdeEndereco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.naturals.Activity.activities.ActivityPagamento;
import com.example.naturals.R;

public class EditarEndereco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_endereco);

    }
    public void btn_voltar_endereco (View view) {
        Intent in = new Intent(EditarEndereco.this, ActivityEndereco.class);
        startActivity(in);
    }
    public void btn_confirmar_endereco (View view) {
        Intent in = new Intent(EditarEndereco.this, ActivityPagamento.class);
        startActivity(in);
    }
}