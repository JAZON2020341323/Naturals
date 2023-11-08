package com.example.naturals.Activity.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.naturals.modelo_de_dados.CadastroProduto;
import com.example.naturals.modelo_de_dados.PopularDomain;
import com.example.naturals.R;
import com.example.naturals.adapter.PopularListAdapter;
import com.example.naturals.teladeperfil.activity_telade_perfil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPupolar;
    private RecyclerView recyclerViewPupolar;
    private Button btnPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        bottom_navigation();

    }



    private void bottom_navigation() {
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ActivityCarrinho.class)));
    }

    private void initRecyclerview() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Café 100g", "O café é conhecido por seu teor de cafeína, um estimulante natural que pode ajudar a melhorar o estado de alerta, a concentração e a função cognitiva.A cafeína presente no café pode ter efeitos positivos no humor, podendo ajudar a reduzir a sensação de fadiga e melhorar o ânimo. Pode aumentar temporariamente a capacidade física, ajudando a melhorar o desempenho em atividades físicas. Atuando também na prevenção de doenças neurodegenerativas, saúde cardiovascular, são antioxidantes, prevenção de diabetes tipo 2 entre outros.",
                "grao5", 10, 4.5,4.00 ));
        items.add(new PopularDomain("Alecrim 100g", "Experimente este Alecrim, mais sabor para suas receitas. Ideal para o preparo de: aves, carneiros, peixes, batatas, omeletes, molhos, frutos do mar e pães. As folhas de alecrim perfumam os grelhados e devem ser adicionadas inteiras ou picadas no final do cozimento para evitar a evaporação dos seus óleos aromáticos, acrescentam um sabor delicioso à maionese.\n",
                "tempero10", 13, 4.2,4.88));

        items.add(new PopularDomain("Goldenskin Complex", "O Goldenskin Complex é um suplemento de Betacaroteno, Licopeno, Tirosina, Riboflavina, Vitaminas A, C, D e E, Selênio, Zinco e Cobre. Adultos (maiores de 19 anos): Ingerir 2 cápsulas ao dia.\n",
                "capsula9", 13, 4.2, 45.20));

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

 public void btncadastrar (View view){
        Intent in = new Intent(MainActivity.this, ActivityCadastroProduto.class);
        startActivity(in);
    }

}