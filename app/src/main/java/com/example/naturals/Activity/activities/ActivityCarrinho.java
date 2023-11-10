package com.example.naturals.Activity.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.naturals.Helper.ChangeNumberItemsListener;
import com.example.naturals.Helper.ManagmentCart;
import com.example.naturals.R;
import com.example.naturals.TelasdeEndereco.ActivityEndereco;
import com.example.naturals.adapter.CartListAdapter;


public class ActivityCarrinho extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private ManagmentCart managmentCart;
    private TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt;
    private double tax;
    private ScrollView scrollView;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        managmentCart = new ManagmentCart(this);

        initView();
        setVariavle();
        initList();
        calcualteCart();
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managmentCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void change() {

                calcualteCart();
            }
        });

        recyclerView.setAdapter(adapter);
        if (managmentCart.getListCart().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calcualteCart() {
        double percentTax = 0.02;  // você pode alterar este valor para o preço do imposto
        double delivery = 10;
        tax = Math.round((managmentCart.getTotalFee() * percentTax * 100.0)) / 100.0;

        double total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100) / 100;
        double itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100;

        totalFeeTxt.setText("R$ " + itemTotal);
        taxTxt.setText("R$ " + tax);
        deliveryTxt.setText("R$ " + delivery);
        totalTxt.setText("R$ " + total);
    }

    private void setVariavle() {

        backBtn.setOnClickListener(v -> finish());
    }

    private void initView() {
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        recyclerView = findViewById(R.id.view3);
        scrollView = findViewById(R.id.scrollView2);
        backBtn = findViewById(R.id.backBtn);
        emptyTxt = findViewById(R.id.emptyTxt);
    }
    public void voltar_home(View view){
        Intent in = new Intent(ActivityCarrinho.this, MainActivity.class);
        startActivity(in);
    }

    public void btnFinalizarCompra(View view){
        Intent in = new Intent(ActivityCarrinho.this, ActivityEndereco.class);
        startActivity(in);
    }
}