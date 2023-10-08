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
                "Curry 100g",
                "O Curry é uma especiaria de origem indiana composta por vários ingredientes, que podem variar conforme a região onde ele foi produzido",
                "R$ 6,30"
        );
        temperosList.add(tempero1);

        Temperos tempero2 = new Temperos(
                R.drawable.tempero2,
                "Alho em pó 100g",
                " Alho em pó se trata da versão desidratada do alho natural, inteiro, aquele que nos acostumamos a ver entre os temperos da cozinha, fatiado e descascados. Este alimento é rico em compostos sulfurados, especialmente alicina, que proporciona o cheiro característico do alho e que é um dos grandes responsáveis pelas suas propriedades funcionais. Além disso, o alho também é rico em vários minerais que nutrem o organismo, como potássio, cálcio e magnésio.",
                "R$ 8,40"
        );
        temperosList.add(tempero2);

        Temperos tempero3 = new Temperos(
                R.drawable.tempero3,
                "Colorau 100g",
                "O colorau Extra Forte tem como predomínio a semente do urucum, com sua cor mais vibrante, sabor forte, terroso, delicado e um pouco apimentado e com um toque amargo.  Por ser naturalmente anti-inflamatório e repleto de antioxidantes em sua composição, o colorau fortalece a imunidade. Sendo assim, ajuda prevenindo doenças e facilitando o tratamento de muitas outras, ao aliviar o processo inflamatório no organismo\n" ,
                "R$ 1,69"
        );
        temperosList.add(tempero3);

        Temperos tempero4 = new Temperos(
                R.drawable.tempero4,
                "Cravo-da-Índia 100g",
                "O cravo-da-índia, além de ter propriedades medicinais também é uma importante fonte de nutrientes, como vitamina A, vitamina E e beta-caroteno. Pode ser utilizado na sua forma natural para enriquecer a alimentação, ou em forma de cremes e óleos, que selecionam algumas propriedades, para o seu uso na cosmética, por exemplo: Combate infecções; Diminui a pressão arterial; Facilita a digestão; e Melhora a cicatrização;\n" ,
                "R$ 5,90"
        );
        temperosList.add(tempero4);

        Temperos tempero5 = new Temperos(
                R.drawable.tempero5,
                "Cúrcuma 100g",
                " De sabor forte e característico e de cor amarelada, a cúrcuma é uma especiaria largamente utilizada na culinária para dar cor a pratos de sabor doce, peixes, arroz e molhos em geral, além de trazer diversos benefícios para saúde.\n" ,
                "R$ 7,00"
        );
        temperosList.add(tempero5);

        Temperos tempero6 = new Temperos(
                R.drawable.tempero6,
                "Lemon Pepper 100g",
                "O Lemon Pepper é um tempero usado para dar um toque cítrico às preparações. Feito a base de cúrcuma, pimenta preta, coentro, salsinha e óleo vegetal. Ingredientes: sal, cúrcuma, cebola granulada, realçador de sabor glutamato monossódico, pimenta preta, coentro, salsinha, óleo vegetal e conservante ácido cítrico. Sugestão de consumo: substitua o sal pelo lemon pepper na hora de temperar a salada!\n",
                "R$ 8,70"
        );
        temperosList.add(tempero6);

        Temperos tempero7 = new Temperos(
                R.drawable.tempero7,
                "Cominho em pó 100g",
                "O cominho em pó é extraído da semente da planta Cuminum Cyminum. Uma especiaria muito utilizada desde a antiguidade. O Cominho é encontrado em abundância na culinária mexicana. No Brasil, é um tempero característico da cozinha baiana, mas que já conquistou o gosto do brasileiro de Norte a Sul do País.",
                "R$ 3,90"
        );
        temperosList.add(tempero7);

        Temperos tempero8 = new Temperos(
                R.drawable.tempero8,
                "Orégano 100g",
                "O orégano é uma erva condimentar tradicional que pode ser usada para temperar alimentos, mas também tem muitos outros usos. O orégano possui propriedades antioxidantes, antimicrobianas, antiinflamatórias e anticancerígenas, de modo que pode ser utilizado para combater fungos, vírus e bactérias, prevenir o desenvolvimento de algumas doenças crônicas como câncer e obesidade, promover a perda de peso melhorando o metabolismo e reduzindo o apetite .",
                "R$ 5,00"
        );
        temperosList.add(tempero8);

        Temperos tempero9 = new Temperos(
                R.drawable.tempero9,
                "Ervas finas 100g",
                " Ervas finas, frescas ou desidratadas, servem para temperar diferentes tipos de pratos e decoração. Para quem gosta de um gostinho a mais na comida, vale apostar nas ervas finas (como cebolinha, salsinha, orégano, tomilho, manjericão, cerefólio e estragão) para completar o prato. As ervas finas trazem um toque especial na hora de preparar uma refeição, pois o básico já não cabe mais, antioxidante, antisséptico, eficaz contra cólicas, diarreias, azia, má digestão, bronquite, aftas, tosses, dores de garganta e outras inflamações na boca.",
                "R$ 6,90"
        );
        temperosList.add(tempero9);

        Temperos tempero10 = new Temperos(
                R.drawable.tempero10,
                "Alecrim 100g",
                "Experimente este Alecrim, mais sabor para suas receitas. Ideal para o preparo de: aves, carneiros, peixes, batatas, omeletes, molhos, frutos do mar e pães. As folhas de alecrim perfumam os grelhados e devem ser adicionadas inteiras ou picadas no final do cozimento para evitar a evaporação dos seus óleos aromáticos, acrescentam um sabor delicioso à maionese.",
                "R$ 4,88"
        );
        temperosList.add(tempero10);
    }
}