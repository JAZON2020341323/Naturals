package com.example.naturals.Activity.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.naturals.Helper.ManagmentCart;
import com.example.naturals.R;
import com.example.naturals.adapter.CapsulasAdapter;
import com.example.naturals.databinding.ActivityListaBinding;
import com.example.naturals.modelo_de_dados.Capsulas;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ActivityLista extends AppCompatActivity {
    private ActivityListaBinding binding;
    private CapsulasAdapter capsulasAdapter;
    private ArrayList<Capsulas> capsulasList = new ArrayList<>();

    private Capsulas object;
    private int numberOrder = 1;

    private ManagmentCart managmentCart;
    private TextView txtCapsulasName, txtCapsulaDescription, txtPrice;
    private Button addToCartBtn;
    private ImageView imageView4;

    private ImageButton fvrt_btn;
    DatabaseReference favouriteref;
    FirebaseDatabase database= FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managmentCart = new ManagmentCart(this);


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
                "O Agar agar é uma gelatina de origem vegetal extraída de algas marinhas.",
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
                "A Amora Miura em cápsulas da Unilife contém em sua composição Amora miúra, ácido ascórbico (vitamina C), zinco, quelato e selenometionina.",
                "R$ 43.00"
        );
        capsulasList.add(capsulas3);

        Capsulas  capsulas4 = new Capsulas(
                R.drawable.capsula4,
                "Berinjela 60 cápsulas Unilife",
                "A berinjela em cápsulas da Unilife contém em sua composição Berinjela em pó.",
                "R$ 21.60"
        );
        capsulasList.add(capsulas4);

        Capsulas  capsulas5 = new Capsulas(
                R.drawable.capsula5,
                "Biodream 60 cápsulas Unilife",
                "O Biodream é um mix de ingredientes. Em sua composição encontramos algas (spirulina e ágar-ágar) e fibras (psyllium e berinjela).",
                "R$ 34.50"
        );
        capsulasList.add(capsulas5);



    Capsulas  capsulas6 = new Capsulas(
            R.drawable.capsula6,
            "Cloreto de Magnésio Hexahidratado 500g Unilife",
            " O  Cloreto de Magnésio Hexahidratado contém em sua composição Cloreto de magnésio hexahidratado P. A., bisglicinato de magnésio, piridoxina, antiumectantes, celulose microcristalina, fosfato tricálcico, dióxido de silício, lubrificante silicato de magnésio. ",
            "R$ 35.50"
    );
        capsulasList.add(capsulas6);

    Capsulas  capsulas7 = new Capsulas(
            R.drawable.capsula7,
            "Colágeno Complex Verisol Supraervas 96 Cápsulas",
            "O Colágeno Complex é um suplemento de Colágeno Verisol, Vitamina C, Ácido Hialurônico e associações como o Vitamina A, Vitamina E, Biotina, Selênio, Zinco e Cobre.",
            "R$ 65.50"
    );
        capsulasList.add(capsulas7);

    Capsulas  capsulas8 = new Capsulas(
            R.drawable.capsula8,
            "Extrato de Própolis Imunicomplex SupraErvas 60 Cápsulas",
            " Própolis é uma substância resinosa obtida pelas abelhas através da colheita de resinas da flora (pasto apícola) da região.",
            "R$ 35.00"
    );
        capsulasList.add(capsulas8);

    Capsulas  capsulas9 = new Capsulas(
            R.drawable.capsula9,
            "Goldenskin Complex Supraervas 60 cápsulas",
            "C O Goldenskin Complex é um suplemento de Betacaroteno, Licopeno, Tirosina, Riboflavina, Vitaminas A, C, D e E, Selênio, Zinco e Cobre. ",
            "R$ 45.20"
    );
        capsulasList.add(capsulas9);

    Capsulas  capsulas10 = new Capsulas(
            R.drawable.capsula10,
            "Imunutry Unilife 60 cápsulas",
            "O Suplemento Alimentar em Cápsulas Imunutry é com combinado de Vitaminas C, D e E e também de Zinco, Glutamina e Extrato de Própolis.",
            "R$ 46.00"
    );
        capsulasList.add(capsulas10);

    }
    }