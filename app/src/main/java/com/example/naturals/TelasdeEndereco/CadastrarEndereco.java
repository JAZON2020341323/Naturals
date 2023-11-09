package com.example.naturals.TelasdeEndereco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.naturals.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastrarEndereco extends AppCompatActivity {


    private EditText EditTextNome, editTextCep, editTextEndereco, editTextTelefone, editTextEstado, editTextCidade;
    private Button btnConfirmar;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_endereco);

        EditTextNome = findViewById(R.id.EditTextNome);
        editTextCep = findViewById(R.id. editTextCep);
        editTextEndereco = findViewById(R.id.editTextEndereco);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        editTextEstado = findViewById(R.id.editTextEstado);
        editTextCidade = findViewById(R.id.editTextCidade);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarEndereco();
            }
        });
    }

    private void cadastrarEndereco() {
        String nome = EditTextNome.getText().toString().trim();
        String cep = editTextCep.getText().toString().trim();
        String endereco = editTextEndereco.getText().toString().trim();
        String telefone = editTextTelefone.getText().toString().trim();
        String estado = editTextEstado.getText().toString().trim();
        String cidade =   editTextCidade.getText().toString().trim();

        // Cria um novo nó no banco de dados
        String userId = mAuth.getCurrentUser().getUid();
        DatabaseReference userRef = mDatabase.child("usuario").child(userId);

        // Salva as informações do endereço no nó do usuário
        userRef.child("nome").setValue(nome);
        userRef.child("endereco").child("cep").setValue(cep);
        userRef.child("endereco").child("logradouro").setValue(endereco);
        userRef.child("telefone").setValue(telefone);
        userRef.child("endereco").child("estado").setValue(estado);
        userRef.child("endereco").child("cidade").setValue(cidade);

        Toast.makeText(this, "Endereço cadastrado com sucesso", Toast.LENGTH_SHORT).show();
    }
}
