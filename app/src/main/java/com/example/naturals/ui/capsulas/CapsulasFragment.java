package com.example.naturals.ui.capsulas;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.naturals.Produto_descricao.activity_produto_descricao;
import com.example.naturals.R;
import com.example.naturals.databinding.FragmentCapsulasBinding;
import com.example.naturals.databinding.FragmentHomeBinding;
import com.example.naturals.formCadastro.TeladeCadastro;
import com.example.naturals.formLogin.TeladeLogin;
import com.example.naturals.ui.home.HomeViewModel;


public class CapsulasFragment extends Fragment {
    private Button Button_100queda;

        private FragmentCapsulasBinding binding;

        public View onCreateView(@NonNull LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState) {
            CapsulasViewModel capsulasViewModel =
                    new ViewModelProvider(this).get(CapsulasViewModel.class);

            binding = FragmentCapsulasBinding.inflate(inflater, container, false);
            View root = binding.getRoot();

            final TextView textView = binding.produtosdisponiveis;
            capsulasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
            return root;


        }



    @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;
        }

    }