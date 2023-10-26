package com.example.naturals.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.naturals.Activity.activities.CapsulasLista;
import com.example.naturals.Activity.activities.Chas_Lista;
import com.example.naturals.Activity.activities.Graos_Lista;
import com.example.naturals.Activity.activities.Temperos_List;
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

        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ActivityCarrinho.class)));
    }

    private void initRecyclerview() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Amora Miura", "\n" +
                " A Amora Miura em cápsulas da Unilife contém em sua composição Amora miúra, ácido ascórbico (vitamina C), zinco, quelato e selenometionina. Cápsula: gelatina vegetariana e água.Sugere-se a ingestão de 3 cápsulas ao dia, após a refeição. Ingerir com líquido. Consumir este produto conforme recomendação de ingestão diária constante na embalagem.\n" +

                "", "capsula3", 15, 4, 43.00));

        items.add(new PopularDomain("Açafrão 60 cápsulas", "\n" +
                "O açafrão (cúrcuma) em cápsulas da Unilife contém em sua composição cenoura, urucum e beterraba.\n" +

                "", "capsula2", 15, 4, 43.00));

        items.add(new PopularDomain("Amendoins 100g", "\n" +
                "Os amendoins são uma boa fonte de proteína vegetal. A proteína é essencial para a construção e reparo dos tecidos do corpo, além de contribuir para a sensação de saciedade.Contém principalmente gorduras insaturadas, incluindo ácidos graxos monoinsaturados e poliinsaturados, que são benéficos para a saúde do coração. Contém também antioxidantes, como vitamina E e resveratrol, que ajudam a combater os radicais livres no corpo e podem contribuir para a saúde celular e vários outros benefícios." +
                "\n" +

                "", "grao1", 15, 4, 2.00));

        items.add(new PopularDomain("Grão de bico 100g", "\n" +
                "O açafrão (cúrcuma) em cápsulas da Unilife contém em sua composição cenoura, urucum e beterraba.\n" +

                "", "grao2", 15, 4, 1.98));

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
        Intent in = new Intent(MainActivity.this, CapsulasLista.class);
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