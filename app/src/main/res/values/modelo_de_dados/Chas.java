package values.modelo_de_dados;

public class Chas {

    int imgCapsulas;
    String capsulasName;
    String capsulasDescription;
    String price;
    public Chas (int imgCapsulas, String capsulasName, String capsulasDescription, String price) {
        this.imgCapsulas = imgCapsulas;
        this.capsulasName = capsulasName;
        this.capsulasDescription = capsulasDescription;
        this.price = price;
    }

    public int getImgCapsulas() {

        return imgCapsulas;
    }


    public String getCapsulasName() {

        return capsulasName;
    }

    public String getCapsulasDescription() {

        return capsulasDescription;
    }


    public String getPrice() {
        return price;
    }
}
