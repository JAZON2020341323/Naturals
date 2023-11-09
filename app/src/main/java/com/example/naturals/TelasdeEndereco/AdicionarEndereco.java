package com.example.naturals.TelasdeEndereco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.naturals.Activity.activities.ActivityPagamento;
import com.example.naturals.Activity.activities.MainActivity;
import com.example.naturals.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdicionarEndereco extends AppCompatActivity {
    private EditText editTextNomeUsuario, editTextEndereco, editTextEstado, editTextCidade, editTextTelefone, editTextCep;
    private Button buttonCadastrar;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_endereco);

    }

    public void btn_voltar_endereco (View view) {
        Intent in = new Intent(AdicionarEndereco.this, ActivityEndereco.class);
        startActivity(in);
    }
    public void btn_confirmar_endereco (View view) {
        Intent in = new Intent(AdicionarEndereco.this, ActivityPagamento.class);
        startActivity(in);
    }
}