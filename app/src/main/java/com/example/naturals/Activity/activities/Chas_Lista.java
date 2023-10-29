package com.example.naturals.Activity.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.naturals.R;
import com.example.naturals.adapter.ChasAdapter;
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
                "Chá verde 1kg",
                "O chá verde é conhecido por suas propriedades antioxidantes devido à presença de compostos como as catequinas.",
                "R$ 29,90"
        );
        chasList.add(cha1);

        Chas cha2 = new Chas(
                R.drawable.cha2,
                "Chá branco 100g",
                " Assim como o chá verde, o chá branco também é conhecido por ser rico em antioxidantes, incluindo catequinas. ",
                "R$ 29,90"
        );
        chasList.add(cha2);

        Chas cha3 = new Chas(
                R.drawable.cha3,
                "Chá erva-mate 1kg",
                " A erva-mate contém cafeína e outros compostos que podem fornecer energia e benefícios à saúde, como antioxidantes.",
                "R$ 23,90"
        );
        chasList.add(cha3);

        Chas cha4 = new Chas(
                R.drawable.cha4,
                "Chá de alcachofra 1kg ",
                "A alcachofra é conhecida por oferecer diversos benefícios à saúde. Ela é rica em fibras, vitaminas e minerais.",
                "R$ 48,90"
        );
        chasList.add(cha4);

        Chas cha5 = new Chas(
                R.drawable.cha5,
                "Chá de alecrim 100g",
                "O alecrim é uma erva aromática que oferece várias vantagens. Ele contém compostos antioxidantes.",
                "R$ 27,00"
        );
        chasList.add(cha5);

        Chas cha6 = new Chas(
                R.drawable.cha6,
                "Chá de cavalinha 1kg",
                "A cavalinha é uma planta conhecida por suas propriedades medicinais e potenciais benefícios para a saúde.",
                "R$ 20,00"
        );
        chasList.add(cha6);

        Chas cha7 = new Chas(
                R.drawable.cha7,
                "Chá de manjericão 100g",
                "O chá de manjericão, feito a partir das folhas da planta de manjericão, pode oferecer diversos benefícios à saúde.",
                "R$ 26,00"
        );
        chasList.add(cha7);

        Chas cha8 = new Chas(
                R.drawable.cha8,
                "Chá de melissa 100g",
                "O chá de melissa, também conhecido como erva-cidreira, é valorizado por suas propriedades medicinais e benefícios potenciais para a saúde.",
                "R$ 30,00"
        );
        chasList.add(cha8);

        Chas cha9 = new Chas(
                R.drawable.cha9,
                "Chá de hibisco 100g",
                "O hibisco, também conhecido como hibisco-sabdariffa, é uma planta que oferece várias vantagens para a saúde.",
                "R$ 8,00"
        );
        chasList.add(cha9);

        Chas cha10 = new Chas(
                R.drawable.cha10,
                "Chá de canela 1kg",
                " O chá de canela é conhecido por seus potenciais benefícios à saúde.",
                "R$ 20,00"
        );
        chasList.add(cha10);
    }

}

