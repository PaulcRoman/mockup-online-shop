package ro.mycodeschool.model;

public class Product {

    private int id;
    private String categorie;
    private String marca;
    private String model;
    private int stock;
    private double pret;


    public Product(int id, String categorie, String marca,String model, int stock, double pret) {
        this.id = id;
        this.categorie = categorie;
        this.marca = marca;
        this.model = model;
        this.stock = stock;
        this.pret = pret;
    }

    public Product(String text){

        this(Integer.parseInt(text.split(",")[0]), text.split(",")[1],text.split(",")[2],
               text.split(",")[3], Integer.parseInt(text.split(",")[4]), Double.parseDouble(text.split(",")[5]));
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getStock() {
        return stock;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString(){

        return this.id+","+this.categorie +","+this.marca +","+this.model+","+this.stock+","+this.pret;
    }

    @Override
    public boolean equals(Object o){
        Product p = (Product) o;

        if (p.getId() == this.id){
            return true;
        }
        return false;
    }


}
