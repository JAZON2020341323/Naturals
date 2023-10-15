package com.example.naturals.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.naturals.Domain.PopularDomain;
import com.example.naturals.Helper.ManagmentCart;
import com.example.naturals.R;

public class DescricaoActivity extends AppCompatActivity {

    private Button addCarrinho;

    private TextView nomeProdutoDescricao, price_item, txtDescricao, scoreTxt;
    private ImageView imgDescricao, backBtn;
    private PopularDomain object;
    private int numberOrder = 1;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);

        managmentCart = new ManagmentCart(this);

        initView();
        getBundle();

    }

    private void getBundle() {
        object = (PopularDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(), "drawable", this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(imgDescricao);

        nomeProdutoDescricao.setText(object.getTitle());
        price_item.setText("$" + object.getPrice());
        txtDescricao.setText(object.getDescription());
        scoreTxt.setText(object.getScore() + "");

        addCarrinho.setOnClickListener(v -> {
            object.setNumberinCart(numberOrder);
            managmentCart.insertFood(object);
        });
        backBtn.setOnClickListener(v -> finish());
    }

    private void initView() {
        addCarrinho = findViewById(R.id.addCarrinho);
        price_item = findViewById(R.id.priceDescricao);
        nomeProdutoDescricao = findViewById(R.id.nomeProdutoDescricao);
        txtDescricao = findViewById(R.id.txtDescricao);
        imgDescricao = findViewById(R.id.imgDescricao);
        scoreTxt = findViewById(R.id.scoreTxt);
        backBtn = findViewById(R.id.backBtn);
    }

}