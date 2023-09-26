package com.example.naturals.modelo_de_dados;

public class ProdutosHorizontal {
    int imgCapsulas;
    String capsulasName;
    String price;

    public ProdutosHorizontal(int imgCapsulas, String capsulasName, String price) {
        this.imgCapsulas = imgCapsulas;
        this.capsulasName = capsulasName;
        this.price = price;
    }

    public int getImgCapsulas() {

        return imgCapsulas;
    }

    public String getCapsulasName() {

        return capsulasName;
    }

    public String getPrice() {

        return price;
    }
}
