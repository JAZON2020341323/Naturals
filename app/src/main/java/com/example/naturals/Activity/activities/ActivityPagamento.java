package com.example.naturals.Activity.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.naturals.R;

public class ActivityPagamento extends AppCompatActivity {

    private View progressBar;
    private ImageView imagemConfirmacao;
    private TextView textoAprovado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);


        progressBar = findViewById(R.id.progressBar);
        imagemConfirmacao = findViewById(R.id.imagem_confirmacao);
        textoAprovado = findViewById(R.id.texto_aprovado);

        animarPagamentoAprovado();
    }


    public void btnVoltar (View view){
        Intent in = new Intent(ActivityPagamento.this, MainActivity.class);
        startActivity(in);
    }


    private void animarPagamentoAprovado() {
        progressBar.setVisibility(View.VISIBLE);;

        progressBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
                imagemConfirmacao.setVisibility(View.VISIBLE);
                textoAprovado.setVisibility(View.VISIBLE);
            }
        }, 3000); // Define o tempo de duração da animação em milissegundos (3 segundos)
    }
}
