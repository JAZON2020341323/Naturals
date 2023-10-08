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

    private  void getCapsulas(){

        Capsulas  capsula1 = new Capsulas(
                R.drawable.capsula1,
                "Agar-Agar 600mg 60 cápsulas Unilife",
                "O Agar agar é uma gelatina de origem vegetal extraída de algas marinhas",
                "R$ 20.50"
        );
        capsulasList.add(capsula1);

        Capsulas  capsula2 = new Capsulas(
                R.drawable.capsula2,
                "Açafrão 60 cápsulas Unilife",
                "O açafrão (cúrcuma) em cápsulas da Unilife contém em sua composição cenoura, urucum e beterraba.",
                "R$ 37.00"
        );
        capsulasList.add(capsula2);


        Capsulas  capsulas3 = new Capsulas(
                R.drawable.capsula3,
                "Amora Miura com vitaminas 120 cápsulas Unilife",
                "A Amora Miura em cápsulas da Unilife contém em sua composição Amora miúra, ácido ascórbico (vitamina C), zinco, quelato e selenometionina. Cápsula: gelatina vegetariana e água.Sugere-se a ingestão de 3 cápsulas ao dia, após a refeição. Ingerir com líquido. Consumir este produto conforme recomendação de ingestão diária constante na embalagem.",
                "R$ 43.00"
        );
        capsulasList.add(capsulas3);

        Capsulas  capsulas4 = new Capsulas(
                R.drawable.capsula4,
                "Berinjela 60 cápsulas Unilife",
                "A berinjela em cápsulas da Unilife contém em sua composição Berinjela em pó. Sugere-se a ingestão de 3 cápsulas, 2 vezes ao dia, 30 minutos antes das refeições. Ingerir com líquido.",
                "R$ 21.60"
        );
        capsulasList.add(capsulas4);

        Capsulas  capsulas5 = new Capsulas(
                R.drawable.capsula5,
                "Biodream 60 cápsulas Unilife",
                "O Biodream é um mix de ingredientes. Em sua composição encontramos algas (spirulina e ágar-ágar) e fibras (psyllium e berinjela).Sugere-se a ingestão de 2 cápsulas, 2 vezes ao dia, antes das refeições. O consumo deste produto deve ser acompanhado da ingestão de líquidos. Consumir este produto conforme recomendação de ingestão diária constante na embalagem.",
                "R$ 34.50"
        );
        capsulasList.add(capsulas5);



    Capsulas  capsulas6 = new Capsulas(
            R.drawable.capsula6,
            "Cloreto de Magnésio Hexahidratado 500g Unilife",
            " O  Cloreto de Magnésio Hexahidratado contém em sua composição Cloreto de magnésio hexahidratado P. A., bisglicinato de magnésio, piridoxina, antiumectantes, celulose microcristalina, fosfato tricálcico, dióxido de silício, lubrificante silicato de magnésio. Cápsula: gelatina vegetariana e água. Sugere-se a ingestão de 3 cápsulas ao dia, após a refeição.",
            "R$ 35.50"
    );
        capsulasList.add(capsulas6);

    Capsulas  capsulas7 = new Capsulas(
            R.drawable.capsula7,
            "Colágeno Complex Verisol Supraervas 96 Cápsulas",
            "O Colágeno Complex é um suplemento de Colágeno Verisol, Vitamina C, Ácido Hialurônico e associações como o Vitamina A, Vitamina E, Biotina, Selênio, Zinco e Cobre.Adultos (maiores de 19 anos): Ingerir 6 cápsulas ao dia.",
            "R$ 65.50"
    );
        capsulasList.add(capsulas7);

    Capsulas  capsulas8 = new Capsulas(
            R.drawable.capsula8,
            "Extrato de Própolis Imunicomplex SupraErvas 60 Cápsulas",
            " Própolis é uma substância resinosa obtida pelas abelhas através da colheita de resinas da flora (pasto apícola) da região, e alteradas pela ação das enzimas contidas em sua saliva. A cor, sabor e o aroma da própolis variam de acordo com sua origem botânica e vem do mel. Possui Zinco, Selênio e as vitaminas A, C, D e E.Indicado para adultos e idosos (acima de 19 anos): 2 cápsulas ao dia.",
            "R$ 35.00"
    );
        capsulasList.add(capsulas8);

    Capsulas  capsulas9 = new Capsulas(
            R.drawable.capsula9,
            "Goldenskin Complex Supraervas 60 cápsulas",
            "C O Goldenskin Complex é um suplemento de Betacaroteno, Licopeno, Tirosina, Riboflavina, Vitaminas A, C, D e E, Selênio, Zinco e Cobre. Adultos (maiores de 19 anos): Ingerir 2 cápsulas ao dia.",
            "R$ 45.20"
    );
        capsulasList.add(capsulas9);

    Capsulas  capsulas10 = new Capsulas(
            R.drawable.capsula10,
            "Imunutry Unilife 60 cápsulas",
            "O Suplemento Alimentar em Cápsulas Imunutry é com combinado de Vitaminas C, D e E e também de Zinco, Glutamina e Extrato de Própolis.Sugere-se a ingestão de uma cápsula, duas vezes ao dia. Ingerir com líquido. Consumir este produto conforme recomendação de ingestão diária constante na embalagem.",
            "R$ 46.00"
    );
        capsulasList.add(capsulas10);

    }
    }