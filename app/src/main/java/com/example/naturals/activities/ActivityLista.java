package com.example.naturals.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.naturals.R;
import com.example.naturals.adapter.CapsulasAdapter;
import com.example.naturals.databinding.ActivityListaBinding;
import com.example.naturals.modelo_de_dados.Capsulas;

import java.util.ArrayList;

public class ActivityLista extends AppCompatActivity {
    private ActivityListaBinding binding;
    private CapsulasAdapter capsulasAdapter;
    private ArrayList<Capsulas> capsulasList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        RecyclerView recyclerViewCapsulas =  binding.RecyclerViewFood;
        recyclerViewCapsulas.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCapsulas.setHasFixedSize(true);
        capsulasAdapter = new CapsulasAdapter(capsulasList, this);
        recyclerViewCapsulas.setAdapter(capsulasAdapter);
        getCapsulas();
    }


    private void getCapsulas(){

        Capsulas  capsula1 = new Capsulas(
                R.drawable.capsula1,
                "Agar-Agar",
                "O Agar agar é uma gelatina de origem vegetal extraída de algas marinhas",
                "R$ 20.00"
        );
        capsulasList.add(capsula1);

        Capsulas  capsula2 = new Capsulas(
                R.drawable.capsula2,
                "Açafrão",
                "O açafrão (cúrcuma) em cápsulas da Unilife contém em sua composição cenoura, urucum e beterraba.",
                "R$ 50.00"
        );
        capsulasList.add(capsula2);


        Capsulas  capsulas3 = new Capsulas(
                R.drawable.capsula3,
                "Capsulas 3",
                "Cacau em pó é bom para saúde",
                "R$ 30.00"
        );
        capsulasList.add(capsulas3);

        Capsulas  capsulas4 = new Capsulas(
                R.drawable.capsula4,
                "Capsulas 4",
                "Cacau em pó é bom para saúde",
                "R$ 10.00"
        );
        capsulasList.add(capsulas4);

        Capsulas  capsulas5 = new Capsulas(
                R.drawable.capsula5,
                "Capsulas 5",
                "Cacau em pó é bom para saúde",
                "R$ 20.00"
        );
        capsulasList.add(capsulas5);

    }
}