package ro.mycodeschool.model;

public class Clienti extends Persoana{



    public Clienti(int id,String nume, String prenume, String functie, String email,  String parola ){
        super(id, nume, prenume, "client", parola, email);

    }

    public Clienti(String text){
        super(Integer.parseInt(text.split(",")[0]),text.split(",")[1],text.split(",")[2],text.split(",")[3],text.split(",")[4],
                text.split(",")[5]);

    }

    public void medodaClient(){
        System.out.println("Metoda clientului");
    }

    @Override
    public String toString(){

        return super.toString();

    }

    @Override
    public boolean equals(Object o){
        Clienti c = (Clienti) o;

      return   super.equals(c);
    }





}

