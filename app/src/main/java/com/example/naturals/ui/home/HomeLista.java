package com.example.naturals.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naturals.R;
import com.example.naturals.adapter.HomeHorAdapter;
import com.example.naturals.modelo_de_dados.HomerHorModel;

import java.util.ArrayList;
import java.util.List;

public class HomeLista extends Fragment {

    RecyclerView homeHorizontalRec;
    List<HomerHorModel> homerHorModelList;
    HomeHorAdapter homeHorAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.home_lista, container, false);

       // homeHorizontalRec = root.findViewById(R.id.home_hor_rec);

        homerHorModelList = new ArrayList<>();

        homerHorModelList.add(new HomerHorModel(R.drawable.vetorencapsulado,"Encapsulados"));
        homerHorModelList.add(new HomerHorModel(R.drawable.tempero1,"Tempeiros"));
        homerHorModelList.add(new HomerHorModel(R.drawable.receitas,"Receitas"));

        //homeHorAdapter = new HomeHorAdapter(getActivity(),homerHorModelList);
       // homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
       homeHorizontalRec.setHasFixedSize(true);
       homeHorizontalRec.setNestedScrollingEnabled(false);
        return root;

    }

}