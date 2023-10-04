package com.example.naturals.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.naturals.R;
import com.example.naturals.adapter.ChasAdapter;
import com.example.naturals.adapter.TemperosAdapter;
import com.example.naturals.databinding.ActivityListaBinding;
import com.example.naturals.modelo_de_dados.Chas;
import com.example.naturals.modelo_de_dados.Temperos;

import java.util.ArrayList;

public class Temperos_List extends AppCompatActivity {

    private ActivityListaBinding binding;

    private TemperosAdapter temperosAdapter;
    private ArrayList<Temperos> temperosList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityListaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        RecyclerView recyclerViewTemperos =  binding.RecyclerViewFood;
        recyclerViewTemperos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTemperos.setHasFixedSize(true);
        temperosAdapter = new TemperosAdapter(temperosList, this);
        recyclerViewTemperos.setAdapter(temperosAdapter);
        getTemperos();
    }

    private void getTemperos(){
        Temperos tempero1 = new Temperos(
                R.drawable.tempero1,
                "Tempero1",
                "Tempero1",
                "R$ 20,00"
        );
        temperosList.add(tempero1);

        Temperos tempero2 = new Temperos(
                R.drawable.tempero2,
                "Tempero2",
                "Tempero2",
                "R$ 20,00"
        );
        temperosList.add(tempero2);

        Temperos tempero3 = new Temperos(
                R.drawable.tempero3,
                "Tempero3",
                "Tempero3",
                "R$ 20,00"
        );
        temperosList.add(tempero3);

        Temperos tempero4 = new Temperos(
                R.drawable.tempero4,
                "Tempero4",
                "Tempero4",
                "R$ 20,00"
        );
        temperosList.add(tempero4);

        Temperos tempero5 = new Temperos(
                R.drawable.tempero5,
                "Tempero5",
                "Tempero5",
                "R$ 20,00"
        );
        temperosList.add(tempero5);

        Temperos tempero6 = new Temperos(
                R.drawable.tempero6,
                "Tempero6",
                "Tempero6",
                "R$ 20,00"
        );
        temperosList.add(tempero6);

        Temperos tempero7 = new Temperos(
                R.drawable.tempero7,
                "Tempero7",
                "Tempero7",
                "R$ 20,00"
        );
        temperosList.add(tempero7);

        Temperos tempero8 = new Temperos(
                R.drawable.tempero8,
                "Tempero8",
                "Tempero8",
                "R$ 20,00"
        );
        temperosList.add(tempero8);

        Temperos tempero9 = new Temperos(
                R.drawable.tempero9,
                "Tempero9",
                "Tempero9",
                "R$ 20,00"
        );
        temperosList.add(tempero9);

        Temperos tempero10 = new Temperos(
                R.drawable.tempero10,
                "Tempero10",
                "Tempero10",
                "R$ 20,00"
        );
        temperosList.add(tempero10);
    }
}