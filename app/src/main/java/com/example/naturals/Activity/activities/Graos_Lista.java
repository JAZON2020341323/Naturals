package com.example.naturals.Activity.activities;

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
                "Amendoins 100g",
                "Os amendoins são uma boa fonte de proteína vegetal. A proteína é essencial para a construção e reparo dos tecidos do corpo, além de contribuir para a sensação de saciedade.",
                "R$ 2,00"
        );
        graosList.add(grao1);

        Graos grao2 = new Graos(
                R.drawable.grao2,
                "Grão de bico 100g",
                "O grão-de-bico é uma excelente fonte de proteína vegetal, o que o torna uma ótima opção para vegetarianos e veganos.",
                "R$1,90"
        );
        graosList.add(grao2);

        Graos grao3 = new Graos(
                R.drawable.grao3,
                "Amêndoas 100g",
                "As amêndoas são ricas em nutrientes, incluindo fibras, proteínas, gorduras saudáveis, vitamina E, magnésio, manganês e folato.",
                "R$ 7,90"
        );
        graosList.add(grao3);

        Graos grao4 = new Graos(
                R.drawable.grao4,
                "Milho 100g",
                "O milho é uma excelente fonte de carboidratos complexos, que são uma fonte de energia de liberação lenta, mantendo os níveis de energia estáveis ao longo do tempo.",
                "R$ 0,95"
        );
        graosList.add(grao4);

        Graos grao5 = new Graos(
                R.drawable.grao5,
                "Café 100g",
                "O café é conhecido por seu teor de cafeína, um estimulante natural que pode ajudar a melhorar o estado de alerta, a concentração e a função cognitiva.",
                "R$ 4,00"
        );
        graosList.add(grao5);

        Graos grao6 = new Graos(
                R.drawable.grao6,
                "Lentilha 100g",
                "A lentilha é uma leguminosa muito nutritiva e versátil, que traz diversos benefícios à saúde.",
                "R$ 2,00"
        );
        graosList.add(grao6);

        Graos grao7 = new Graos(
                R.drawable.grao7,
                "Semente de girassol 100g",
                "As sementes de girassol são uma excelente fonte de nutrientes e oferecem diversos benefícios à saúde quando consumidas com moderação. ",
                "R$ 10,00"
        );
        graosList.add(grao7);

        Graos grao8 = new Graos(
                R.drawable.grao8,
                "Aveia 100g",
                " A aveia é um alimento altamente nutritivo e versátil, conhecido por seus diversos benefícios à saúde.",
                "R$ 1,30"
        );
        graosList.add(grao8);

        Graos grao9 = new Graos(
                R.drawable.grao9,
                "Chia 100g",
                "Semente de chia fornecem muitas benefícios para a saúde. A chia (Salvia hispanica L.) é uma planta herbácea da família das lamiáceas, da qual também fazem parte o linho e a sálvia. ",
                "R$ 6,00"
        );
        graosList.add(grao9);

        Graos grao10 = new Graos(
                R.drawable.grao10,
                "Linhaça dourada 100g",
                "A linhaça é a semente do linho. É usada há mais de 5000 anos e hoje é considerada um alimento funcional devido aos seus conhecidos benefícios para a saúde.",
                "R$ 5,00"
        );
        graosList.add(grao10);
    }
}