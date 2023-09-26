package com.example.naturals.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.naturals.adapter.ChasAdapter;
import com.example.naturals.databinding.ActivityListaBinding;

import java.util.ArrayList;

public class Chas extends AppCompatActivity {

    private ActivityListaBinding binding;
    private ChasAdapter chasAdapter;
    private ArrayList<Chas> chasList = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityListaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        super.onCreate(savedInstanceState);

        RecyclerView recyclerViewFood = binding.RecyclerViewFood;
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewFood.setHasFixedSize(true);
        chasAdapter = new ChasAdapter(chasList, this);
        recyclerViewFood.setAdapter(chasAdapter);


    }

}

