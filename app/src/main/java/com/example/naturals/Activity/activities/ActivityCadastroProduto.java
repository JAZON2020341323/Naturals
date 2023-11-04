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
        setContentView(R.layout.activity_cadastro_produto);

        // Inicialize o Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("produtos");

        editTextNome = findViewById(R.id.editTextNome);
        editTextValor = findViewById(R.id.editTextValor);
    }



    public void adicionarImagem(View view) {
        // Use o nome da imagem selecionada da pasta "drawable"
        String selectedImageName = "capsula1.png"; // Substitua "nome_da_imagem" pelo nome real da imagem na pasta "drawable"

        // Para acessar a imagem selecionada da pasta "drawable", você pode usar seu nome de recurso
        int selectedImageResourceId = getResources().getIdentifier(selectedImageName, "drawable", getPackageName());

        if (selectedImageResourceId != 0) {
            // Faça algo com a imagem selecionada, como exibi-la em uma ImageView
            ImageView imageView = findViewById(R.id.imageView); // Substitua "imageView" pelo ID da sua ImageView
            imageView.setImageResource(selectedImageResourceId);
        } else {
            // Lidar com o caso em que a imagem não foi encontrada na pasta "drawable"
        }
    }

    public void selecionarCategoria(View view) {
        final String[] categorias = {"CÁPSULAS", "GRÃOS", "TEMPEROS", "CHÁS"};

        // Implementação usando AlertDialog para seleção de categoria

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecione a Categoria");
        builder.setItems(categorias, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                categoriaSelecionada = categorias[which];
                Toast.makeText(getApplicationContext(), "Categoria selecionada: " + categoriaSelecionada, Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    private static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            // Faça algo com a imagem selecionada, como fazer o upload para o Firebase Storage.
        }
    }



    public void cadastrarProduto(View view) {
        String nome = editTextNome.getText().toString();
        String valor = editTextValor.getText().toString();
        String imagem = ""; // Armazene aqui o caminho da imagem no armazenamento do Firebase após o upload.

        if (!nome.isEmpty() && !valor.isEmpty() && !imagem.isEmpty() && !categoriaSelecionada.isEmpty()) {
            // Crie um objeto Produto com os dados
            CadastroProduto produto = new CadastroProduto(nome, valor, imagem);

            // Salve o produto no banco de dados Firebase na categoria selecionada
            databaseReference.child(categoriaSelecionada).push().setValue(produto);

            Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Preencha todos os campos e selecione uma categoria", Toast.LENGTH_SHORT).show();
        }
    }




}