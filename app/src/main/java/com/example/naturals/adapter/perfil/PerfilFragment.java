package com.example.naturals.adapter.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.naturals.R;

public class PerfilFragment extends Fragment {

    private ImageView profileImage;
    private TextView profileName;
    private TextView profileEmail;
    private TextView profilePassword;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        // Inicialize os elementos da interface do usuário
        profileImage = view.findViewById(R.id.profileImage);
        profileName = view.findViewById(R.id.profileName);
        profileEmail = view.findViewById(R.id.profileEmail);
        profilePassword = view.findViewById(R.id.profilePassword);

        // Defina os valores dos elementos da interface do usuário
        profileName.setText("Nome do Usuário"); // Substitua pelo nome real do usuário
        profileEmail.setText("email@example.com"); // Substitua pelo email real do usuário
        profilePassword.setText("********"); // Substitua pela senha real do usuário
        // Carregue a imagem do perfil aqui

        return view;
    }
}
