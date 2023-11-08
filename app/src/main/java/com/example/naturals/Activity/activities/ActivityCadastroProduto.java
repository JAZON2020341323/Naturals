package com.example.naturals.Activity.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.naturals.R;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;

import com.example.naturals.modelo_de_dados.CadastroProduto;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityCadastroProduto extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private EditText editTextNome, editTextValor;

    private ArrayAdapter<CharSequence> adapter;
    private String categoriaSelecionada = ""; // Armazenar a categoria selecionada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_produto);

    }

    }