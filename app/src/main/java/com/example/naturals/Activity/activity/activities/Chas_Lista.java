package com.example.naturals.Activity.activity.activities;

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
                "O chá verde é conhecido por suas propriedades antioxidantes devido à presença de compostos como as catequinas. Esses antioxidantes podem ajudar a combater o estresse oxidativo no corpo. Além disso, o chá verde também pode ser associado a benefícios para a saúde, como melhora na função cerebral, aumento do metabolismo e possível redução do risco de certas doenças, como doenças cardíacas.\n",
                "R$ 29,90"
        );
        chasList.add(cha1);

        Chas cha2 = new Chas(
                R.drawable.cha2,
                "Chá branco 100g",
                " Assim como o chá verde, o chá branco também é conhecido por ser rico em antioxidantes, incluindo catequinas. Devido ao seu processamento mínimo, o chá branco tende a preservar mais desses antioxidantes em comparação com outros tipos de chá. Esses antioxidantes podem contribuir para a proteção das células contra danos causados pelos radicais livres.O chá branco também é apreciado por sua potencial capacidade de melhorar a saúde cardiovascular, reduzir o risco de certas doenças crônicas e até mesmo auxiliar na perda de peso.",
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
                "A alcachofra é conhecida por oferecer diversos benefícios à saúde. Ela é rica em fibras, vitaminas (como vitamina C, vitamina K e vitaminas do complexo B) e minerais (como magnésio, potássio e ferro). Alguns benefícios potenciais incluem a promoção da saúde digestiva devido às fibras, apoio à função hepática e redução do colesterol devido a compostos como a cinarina, e propriedades antioxidantes que podem ajudar a combater o estresse oxidativo no corpo. Além disso, a alcachofra também pode ter efeitos positivos na regulação do açúcar no sangue e na manutenção do peso saudável.",
                "R$ 48,90"
        );
        chasList.add(cha4);

        Chas cha5 = new Chas(
                R.drawable.cha5,
                "Chá de alecrim 100g",
                "O alecrim é uma erva aromática que oferece várias vantagens. Ele contém compostos antioxidantes, como ácido rosmarínico e flavonoides, que podem ajudar a combater o estresse oxidativo no corpo. Algumas vantagens do alecrim incluem: melhoria da memória, propriedades anti inflamatórias, suporte digestivo, ação antimicrobiana, potencial para cabelos e couro cabeludo, sabor na culinária.",
                "R$ 27,00"
        );
        chasList.add(cha5);

        Chas cha6 = new Chas(
                R.drawable.cha6,
                "Chá de cavalinha 1kg",
                "A cavalinha é uma planta conhecida por suas propriedades medicinais e potenciais benefícios para a saúde. Alguns dos benefícios associados à cavalinha incluem: Diurético natural, fortalecimento dos ossos, saúde das unhas e cabelos, propriedades antioxidantes, saúde da pele, saúde do trato urinário.\n",
                "R$ 20,00"
        );
        chasList.add(cha6);

        Chas cha7 = new Chas(
                R.drawable.cha7,
                "Chá de manjericão 100g",
                "O chá de manjericão, feito a partir das folhas da planta de manjericão, pode oferecer diversos benefícios à saúde. Alguns dos benefícios potenciais do chá de manjericão incluem: efeito calmante, propriedades anti-inflamatórias, melhoria na digestão, suporte ao sistema imunológico, alívio de sintomas respiratórios e efeito antioxidante.\n",
                "R$ 26,00"
        );
        chasList.add(cha7);

        Chas cha8 = new Chas(
                R.drawable.cha8,
                "Chá de melissa 100g",
                "O chá de melissa, também conhecido como erva-cidreira, é valorizado por suas propriedades medicinais e benefícios potenciais para a saúde. Alguns dos benefícios do chá de melissa incluem: efeito calmante, melhoria do sono, alívio de distúrbios digestivos, efeito antioxidante, apoio ao sistema imunológico, alívio de sintomas de resfriado, apoio ao sistema nervoso, melhoria do humor.",
                "R$ 30,00"
        );
        chasList.add(cha8);

        Chas cha9 = new Chas(
                R.drawable.cha9,
                "Chá de hibisco 100g",
                "O hibisco, também conhecido como hibisco-sabdariffa, é uma planta que oferece várias vantagens para a saúde. Algumas das vantagens associadas ao hibisco incluem: propriedades antioxidantes, controle da pressão arterial, saúde cardiovascular, gerenciamento de peso, função digestiva, controle do açúcar no sangue, apoio ao sistema imunológico e saúde da pele.",
                "R$ 8,00"
        );
        chasList.add(cha9);

        Chas cha10 = new Chas(
                R.drawable.cha10,
                "Chá de canela 1kg",
                " O chá de canela é conhecido por seus potenciais benefícios à saúde. No entanto, é importante notar que a canela deve ser consumida com moderação, especialmente em grandes quantidades, devido ao seu teor de cumarina, que pode ser tóxico em doses elevadas, alguns de seus benefícios são: regulação dos níveis de açúcar no sangue, propriedades antioxidantes, melhoria da saúde cardiovascular, ação anti inflamatória,suporte ao sistema imunológico, melhoria da digestão, potencial para perda de peso, aquecimento do corpo.",
                "R$ 20,00"
        );
        chasList.add(cha10);
    }

}

