package com.example.naturals.modelo_de_dados;

public class CadastroProduto {
        private String nome;
        private String valor;
        private String imagem;


        public CadastroProduto(){

        }

    public CadastroProduto (String nome, String valor, String imagem) {
        this.nome = nome;
        this.valor = valor;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getValor() {
        return valor;
    }

    public String getImagem() {
        return imagem;
    }
}

