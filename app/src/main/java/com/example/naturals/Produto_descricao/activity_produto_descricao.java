package com.example.naturals.Produto_descricao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.naturals.activities.ActivityMenu;
import com.example.naturals.catalogodeprodutos.Catalogode_produtos;
import com.example.naturals.R;

public class activity_produto_descricao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_descricao);
    }
    public void Voltar(View view) {
        Intent in = new Intent(activity_produto_descricao.this, ActivityMenu.class);
        startActivity(in);
    }
    public void Catalogo(View view) {
        Intent in = new Intent(activity_produto_descricao.this, Catalogode_produtos.class);
        startActivity(in);
    }
}