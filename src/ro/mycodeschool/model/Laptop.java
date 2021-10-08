package ro.mycodeschool.model;

public class Laptop extends Product{

    private String configuratie;

    public Laptop(int id, String nume, String marca, String model, int stoc, double pret, String configuratie){
        super(id, nume, marca, model, stoc, pret);
        this.configuratie = configuratie;
    }

    public Laptop(String text){
        super(Integer.parseInt(text.split(",")[0]), text.split(",")[1], text.split(",")[2], text.split(",")[3], Integer.parseInt(text.split(",")[4]), Double.parseDouble(text.split(",")[5]));
        this.configuratie = text.split(",")[6];
    }

    public String getConfiguratie() {
        return configuratie;
    }

    public void setConfiguratie(String configuratie) {
        this.configuratie = configuratie;
    }

    @Override
    public String toString(){
        return super.toString()+","+this.configuratie;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Laptop) {
            Laptop l = (Laptop) o;

            return super.equals(l) && this.configuratie.equals(l.getConfiguratie());
        }

        return false;
    }

}
