package com.example.naturals.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.naturals.Activity.activities.ActivityLista;
import com.example.naturals.Activity.activities.Chas_Lista;
import com.example.naturals.Activity.activities.Graos_Lista;
import com.example.naturals.Activity.activities.Temperos_List;
import com.example.naturals.modelo_de_dados.Capsulas;
import com.example.naturals.modelo_de_dados.PopularDomain;
import com.example.naturals.R;
import com.example.naturals.adapter.PopularListAdapter;
import com.example.naturals.teladeperfil.activity_telade_perfil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPupolar;
    private RecyclerView recyclerViewPupolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        bottom_navigation();

    }

    private void bottom_navigation() {
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }

    private void initRecyclerview() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("MacBook Pro 13 M2 chip", "Discover the new MacBook Pro 13 featuring the\n" +
                " powerful M2 chip. This cutting-edge laptop\n" +
                " redefines performance and portability. With its \n" +
                "sleek design and advanced technology, the\n" +
                " MacBook Pro 13 M2 chip is your ultimate\n" +
                " companion for productivity, creativity, and\n" +
                " entertainment. Experience seamless multitasking, \n" +
                "stunning visuals on the Retina display, and\n" +
                " enhanced security with Touch ID. Take your\n" +
                " computing experience to the next level with the \n" +
                "MacBook Pro 13 M2 chip.", "pic", 15, 4, 500));
        items.add(new PopularDomain("Ps-5 Digital", "Discover the new MacBook Pro 13 featuring the\n" +
                " powerful M2 chip. This cutting-edge laptop\n" +
                " redefines performance and portability. With its \n" +
                "sleek design and advanced technology, the\n" +
                " MacBook Pro 13 M2 chip is your ultimate\n" +
                " companion for productivity, creativity, and\n" +
                " entertainment. Experience seamless multitasking, \n" +
                "stunning visuals on the Retina display, and\n" +
                " enhanced security with Touch ID. Take your\n" +
                " computing experience to the next level with the \n" +
                "MacBook Pro 13 M2 chip.", "pic3", 10, 4.5, 450));
        items.add(new PopularDomain("IPhone 14", "Discover the new MacBook Pro 13 featuring the\n" +
                " powerful M2 chip. This cutting-edge laptop\n" +
                " redefines performance and portability. With its \n" +
                "sleek design and advanced technology, the\n" +
                " MacBook Pro 13 M2 chip is your ultimate\n" +
                " companion for productivity, creativity, and\n" +
                " entertainment. Experience seamless multitasking, \n" +
                "stunning visuals on the Retina display, and\n" +
                " enhanced security with Touch ID. Take your\n" +
                " computing experience to the next level with the \n" +
                "MacBook Pro 13 M2 chip.", "pic2", 13, 4.2, 800));

        items.add(new PopularDomain("Capsula", "Discover the new MacBook Pro 13 featuring the\n" +
                " powerful M2 chip. This cutting-edge laptop\n" +
                " redefines performance and portability. With its \n" +
                "sleek design and advanced technology, the\n" +
                " MacBook Pro 13 M2 chip is your ultimate\n" +
                " companion for productivity, creativity, and\n" +
                " entertainment. Experience seamless multitasking, \n" +
                "stunning visuals on the Retina display, and\n" +
                " enhanced security with Touch ID. Take your\n" +
                " computing experience to the next level with the \n" +
                "MacBook Pro 13 M2 chip.", "capsula1", 13, 4.2, 800));

        recyclerViewPupolar = findViewById(R.id.view1);
        recyclerViewPupolar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterPupolar = new PopularListAdapter(items);
        recyclerViewPupolar.setAdapter(adapterPupolar);
    }

    public void btnChat (View view){
        Intent in = new Intent(MainActivity.this, com.example.naturals.ui.faleconosco.MainActivity.class);
        startActivity(in);
    }

    public void btnPerfil (View view){
        Intent in = new Intent(MainActivity.this, activity_telade_perfil.class);
        startActivity(in);
    }

    public void btnCapsula (View view){
        Intent in = new Intent(MainActivity.this, ActivityLista.class);
        startActivity(in);
    }

    public void btnTempero (View view){
        Intent in = new Intent(MainActivity.this, Temperos_List.class);
        startActivity(in);
    }
    public void btnGrao (View view){
        Intent in = new Intent(MainActivity.this, Graos_Lista.class);
        startActivity(in);
    }

    public void btnCha (View view){
        Intent in = new Intent(MainActivity.this, Chas_Lista.class);
        startActivity(in);
    }

}