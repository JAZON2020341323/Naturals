package com.example.naturals.catalogodeprodutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.naturals.Produto_descricao.activity_produto_descricao;
import com.example.naturals.R;
import com.example.naturals.activities.ActivityMenu;

public class Catalogode_produtos extends AppCompatActivity {

    private Button imageButton_100queda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogode_produtos);

    }

    public void Voltar(View view) {
        Intent in = new Intent(Catalogode_produtos.this, ActivityMenu.class);
        startActivity(in);
    }

    public void semqueda (View view) {
        Intent in = new Intent(Catalogode_produtos.this, activity_produto_descricao.class);
        startActivity(in);
    }
}