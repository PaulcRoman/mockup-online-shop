package ro.mycodeschool.model;

public class Administrator extends Persoana{



    public Administrator(int id, String nume, String prenume, String functie, String email,  String parola){
        super(id, nume, prenume, "adimin", email, parola);

    }

    public Administrator(String text){
        super(Integer.parseInt(text.split(",")[0]),text.split(",")[1], text.split(",")[2], text.split(",")[3], text.split(",")[4],
                text.split(",")[5]);

    }

    public void metodaAdmn(){
        System.out.println("Metoda administrator");
    }

    @Override
    public String toString(){

        return super.toString();
    }

    @Override
    public boolean equals(Object o){

        Administrator a = (Administrator) o;

        return super.equals(a);

    }


}
