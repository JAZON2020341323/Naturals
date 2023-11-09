package com.example.naturals.TelasdeEndereco;

public class EnderecoUsuario {
    private String nomeUsuario;
    private String endereco;
    private String estado;
    private String cidade;
    private String telefone;
    private String cep;

    public EnderecoUsuario() {
        // Construtor vazio é necessário para Firebase
    }

    public EnderecoUsuario(String nomeUsuario, String endereco, String estado, String cidade, String telefone, String cep) {
        this.nomeUsuario = nomeUsuario;
        this.endereco = endereco;
        this.estado = estado;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}