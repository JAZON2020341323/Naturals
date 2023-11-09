package com.example.naturals.TelasdeEndereco;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.naturals.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdicionarEndereco extends AppCompatActivity {

        private EditText editTextNome;
        private EditText editTextEndereco;
        private EditText editTextEstado;
        private EditText editTextCidade;
        private EditText editTextTelefone;
        private EditText editTextCep;
        private Button buttonCadastrar;
        private DatabaseReference databaseReference;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_adicionar_endereco);

            // Inicialize o Firebase
            databaseReference = FirebaseDatabase.getInstance().getReference("usuario");

            // Associe os elementos de layout aos objetos Java
            editTextNome = findViewById(R.id.editTextNome);
            editTextEndereco = findViewById(R.id.editTextEndereco);
            editTextEstado = findViewById(R.id.editTextEstado);
            editTextCidade = findViewById(R.id.editTextCidade);
            editTextTelefone = findViewById(R.id.editTextTelefone);
            editTextCep = findViewById(R.id.editTextCep);
            buttonCadastrar = findViewById(R.id.buttonCadastrar);

            buttonCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Obtenha os valores dos campos de entrada
                    String nomeUsuario = editTextNome.getText().toString();
                    String endereco = editTextEndereco.getText().toString();
                    String estado = editTextEstado.getText().toString();
                    String cidade = editTextCidade.getText().toString();
                    String telefone = editTextTelefone.getText().toString();
                    String cep = editTextCep.getText().toString();

                    // Crie um objeto para armazenar os dados
                    EnderecoUsuario enderecoObj = new EnderecoUsuario(nomeUsuario, endereco, estado, cidade, telefone, cep);

                    // Envie os dados para o Firebase
                    databaseReference.push().setValue(enderecoObj);

                    // Limpe os campos após o cadastro
                    editTextNome.setText("");
                    editTextEndereco.setText("");
                    editTextEstado.setText("");
                    editTextCidade.setText("");
                    editTextTelefone.setText("");
                    editTextCep.setText("");
                }
            });
        }
    }