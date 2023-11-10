package com.example.naturals.TelasdeEndereco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.naturals.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;

public class CadastrarEndereco extends AppCompatActivity {

    private EditText EditTextNome, editTextCep, editTextEndereco, editTextTelefone, editTextEstado, editTextCidade;
    private TextView textViewnome, textViewendereco, textViewEstado, textViewCidade, textViewcep, textViewtelefone;
    private Button btnConfirmar;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    String usuarioID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_endereco);
        SalvarDadosUsuario();

        EditTextNome = findViewById(R.id.EditTextNome);
        editTextCep = findViewById(R.id.editTextCep);
        editTextEndereco = findViewById(R.id.editTextEndereco);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        editTextEstado = findViewById(R.id.editTextEstado);
        editTextCidade = findViewById(R.id.editTextCidade);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

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
        String cidade = editTextCidade.getText().toString().trim();

        // Cria uma referência para o documento do usuário no Firestore
        String userId = mAuth.getCurrentUser().getUid();
        DocumentReference userRef = db.collection("Usuario").document(userId);

        // Crie um mapa com os dados a serem salvos
        Map<String, Object> enderecoData = new HashMap<>();
        enderecoData.put("nome", nome);
        enderecoData.put("cep", cep);
        enderecoData.put("logradouro", endereco);
        enderecoData.put("telefone", telefone);
        enderecoData.put("estado", estado);
        enderecoData.put("cidade", cidade);

        // Salve os dados no Firestore
        userRef.set(enderecoData)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(CadastrarEndereco.this, "Endereço cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CadastrarEndereco.this, "Erro ao cadastrar endereço", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void SalvarDadosUsuario() {
        String nome = textViewnome.getText().toString();
        String endereco = textViewendereco.getText().toString();
        String estado = textViewEstado.getText().toString();
        String cidade = textViewCidade.getText().toString();
        String cep = textViewcep.getText().toString();
        String telefone =  textViewtelefone.getText().toString();
        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuario").document(usuarioID);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> Usuario = new HashMap<>();
        Usuario.put("nome", nome);
        Usuario.put("logradouro", endereco);
        Usuario.put("estado", estado);
        Usuario.put("cidade", cidade);
        Usuario.put("cep", cep);
        Usuario.put("telefone", telefone);

        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();


    }
}
