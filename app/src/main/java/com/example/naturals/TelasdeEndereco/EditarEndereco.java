package com.example.naturals.TelasdeEndereco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.naturals.Activity.activities.ActivityCarrinho;
import com.example.naturals.Activity.activities.MainActivity;
import com.example.naturals.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class EditarEndereco extends AppCompatActivity {

    private EditText EditTextNome, editTextCep, editTextEndereco, editTextTelefone, editTextEstado, editTextCidade;
    private Button btnConfirmar;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_endereco);

        public void voltar_endereco(View view){
            Intent in = new Intent(EditarEndereco.this, ActivityEndereco.class);
            startActivity(in);
        }

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
                atualizarEndereco();
            }
        });

        // Carregue os dados do endereço existente (se houver)
        carregarDadosEndereco();
    }

    private void carregarDadosEndereco() {
        String userId = mAuth.getCurrentUser().getUid();
        DocumentReference userRef = db.collection("Usuario").document(userId);

        userRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String nome = documentSnapshot.getString("nome");
                    String cep = documentSnapshot.getString("cep");
                    String endereco = documentSnapshot.getString("logradouro");
                    String telefone = documentSnapshot.getString("telefone");
                    String estado = documentSnapshot.getString("estado");
                    String cidade = documentSnapshot.getString("cidade");

                    EditTextNome.setText(nome);
                    editTextCep.setText(cep);
                    editTextEndereco.setText(endereco);
                    editTextTelefone.setText(telefone);
                    editTextEstado.setText(estado);
                    editTextCidade.setText(cidade);
                }
            }
        });
    }

    private void atualizarEndereco() {
        String nome = EditTextNome.getText().toString().trim();
        String cep = editTextCep.getText().toString().trim();
        String endereco = editTextEndereco.getText().toString().trim();
        String telefone = editTextTelefone.getText().toString().trim();
        String estado = editTextEstado.getText().toString().trim();
        String cidade = editTextCidade.getText().toString().trim();

        String userId = mAuth.getCurrentUser().getUid();
        DocumentReference userRef = db.collection("Usuario").document(userId);

        Map<String, Object> enderecoData = new HashMap<>();
        enderecoData.put("nome", nome);
        enderecoData.put("cep", cep);
        enderecoData.put("logradouro", endereco);
        enderecoData.put("telefone", telefone);
        enderecoData.put("estado", estado);
        enderecoData.put("cidade", cidade);

        userRef.set(enderecoData)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(EditarEndereco.this, "Endereço atualizado com sucesso", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(EditarEndereco.this, "Erro ao atualizar endereço", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
