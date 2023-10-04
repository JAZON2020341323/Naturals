package com.example.naturals.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.naturals.R;
import com.example.naturals.adapter.ChasAdapter;
import com.example.naturals.adapter.GraosAdapter;
import com.example.naturals.databinding.ActivityListaBinding;
import com.example.naturals.modelo_de_dados.Chas;

import java.util.ArrayList;

public class Chas_Lista extends AppCompatActivity {

    private ActivityListaBinding binding;

    private ChasAdapter chasAdapter;
    private ArrayList<Chas> chasList = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        RecyclerView recyclerViewChas =  binding.RecyclerViewFood;
        recyclerViewChas.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewChas.setHasFixedSize(true);
        chasAdapter = new ChasAdapter(chasList, this);
        recyclerViewChas.setAdapter(chasAdapter);
        getChas();
    }

    private void getChas(){
        Chas cha1 = new Chas(
                R.drawable.cha1,
                "Cha1",
                "Cha1",
                "R$ 20,00"
        );
        chasList.add(cha1);

        Chas cha2 = new Chas(
                R.drawable.cha2,
                "Cha2",
                "Cha2",
                "R$ 20,00"
        );
        chasList.add(cha2);

        Chas cha3 = new Chas(
                R.drawable.cha3,
                "Cha3",
                "Cha3",
                "R$ 20,00"
        );
        chasList.add(cha3);

        Chas cha4 = new Chas(
                R.drawable.cha4,
                "Cha4",
                "Cha4",
                "R$ 20,00"
        );
        chasList.add(cha4);

        Chas cha5 = new Chas(
                R.drawable.cha5,
                "Cha5",
                "Cha5",
                "R$ 20,00"
        );
        chasList.add(cha5);

        Chas cha6 = new Chas(
                R.drawable.cha6,
                "Cha6",
                "Cha6",
                "R$ 20,00"
        );
        chasList.add(cha6);

        Chas cha7 = new Chas(
                R.drawable.cha7,
                "Cha7",
                "Cha7",
                "R$ 20,00"
        );
        chasList.add(cha7);

        Chas cha8 = new Chas(
                R.drawable.cha8,
                "Cha8",
                "Cha8",
                "R$ 20,00"
        );
        chasList.add(cha8);

        Chas cha9 = new Chas(
                R.drawable.cha9,
                "Cha9",
                "Cha9",
                "R$ 20,00"
        );
        chasList.add(cha9);

        Chas cha10 = new Chas(
                R.drawable.cha10,
                "Cha10",
                "Cha10",
                "R$ 20,00"
        );
        chasList.add(cha10);
    }

}

