package com.example.naturals.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.naturals.R;
import com.example.naturals.adapter.GraosAdapter;
import com.example.naturals.databinding.ActivityListaBinding;
import com.example.naturals.modelo_de_dados.Graos;

import java.util.ArrayList;

public class Graos_Lista extends AppCompatActivity {

    private ActivityListaBinding binding;
    private GraosAdapter graosAdapter;
    private ArrayList<Graos> graosList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        RecyclerView recyclerViewGraos =  binding.RecyclerViewFood;
        recyclerViewGraos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewGraos.setHasFixedSize(true);
        graosAdapter = new GraosAdapter(graosList, this);
        recyclerViewGraos.setAdapter(graosAdapter);
        getGraos();
    }

    private void getGraos(){
        Graos grao1 = new Graos(
                R.drawable.grao1,
                "grao1",
                "grao1",
                "R$ 20"
        );
        graosList.add(grao1);

        Graos grao2 = new Graos(
                R.drawable.grao2,
                "grao2",
                "grao2",
                "R$ 20"
        );
        graosList.add(grao2);

        Graos grao3 = new Graos(
                R.drawable.grao3,
                "grao3",
                "grao3",
                "R$ 20"
        );
        graosList.add(grao3);

        Graos grao4 = new Graos(
                R.drawable.grao4,
                "grao4",
                "grao4",
                "R$ 20"
        );
        graosList.add(grao4);

        Graos grao5 = new Graos(
                R.drawable.grao5,
                "grao5",
                "grao5",
                "R$ 20"
        );
        graosList.add(grao5);

        Graos grao6 = new Graos(
                R.drawable.grao6,
                "grao6",
                "grao6",
                "R$ 20"
        );
        graosList.add(grao6);

        Graos grao7 = new Graos(
                R.drawable.grao7,
                "grao7",
                "grao7",
                "R$ 20"
        );
        graosList.add(grao7);

        Graos grao8 = new Graos(
                R.drawable.grao8,
                "grao8",
                "grao8",
                "R$ 20"
        );
        graosList.add(grao8);

        Graos grao9 = new Graos(
                R.drawable.grao9,
                "grao9",
                "grao9",
                "R$ 20"
        );
        graosList.add(grao9);

        Graos grao10 = new Graos(
                R.drawable.grao10,
                "grao10",
                "grao10",
                "R$ 20"
        );
        graosList.add(grao10);
    }
}