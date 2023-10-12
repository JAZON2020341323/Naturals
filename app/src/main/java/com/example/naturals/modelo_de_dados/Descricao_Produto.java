package com.example.naturals.modelo_de_dados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.naturals.R;

public class Descricao_Produto extends AppCompatActivity {
    Button addCarrinho;

    String nomeProdutoDescricao;
    String priceDescricao;
    String viewDescricao;
    String reviewTxt;

    int  imgDescricao;

    public Button getAddCarrinho() {
        return addCarrinho;
    }

    public void setAddCarrinho(Button addCarrinho) {
        this.addCarrinho = addCarrinho;
    }

    public String getNomeProdutoDescricao() {
        return nomeProdutoDescricao;
    }

    public void setNomeProdutoDescricao(String nomeProdutoDescricao) {
        this.nomeProdutoDescricao = nomeProdutoDescricao;
    }

    public String getPriceDescricao() {
        return priceDescricao;
    }

    public void setPriceDescricao(String priceDescricao) {
        this.priceDescricao = priceDescricao;
    }

    public String getViewDescricao() {
        return viewDescricao;
    }

    public void setViewDescricao(String viewDescricao) {
        this.viewDescricao = viewDescricao;
    }

    public String getReviewTxt() {
        return reviewTxt;
    }

    public void setReviewTxt(String reviewTxt) {
        this.reviewTxt = reviewTxt;
    }

    public int getImgDescricao() {
        return imgDescricao;
    }

    public void setImgDescricao(int imgDescricao) {
        this.imgDescricao = imgDescricao;
    }

    public Descricao_Produto (int imgDescricao, Button addCarrinho, String nomeProdutoDescricao, String priceDescricao, String viewDescricao, String reviewTxt){
        this.imgDescricao = imgDescricao;
        this.nomeProdutoDescricao = nomeProdutoDescricao;
        this.priceDescricao = priceDescricao;
        this.viewDescricao = viewDescricao;
        this.reviewTxt = reviewTxt;
        this.addCarrinho = addCarrinho;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }
}