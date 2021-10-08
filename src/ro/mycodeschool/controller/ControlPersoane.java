package ro.mycodeschool.controller;

import ro.mycodeschool.model.Administrator;
import ro.mycodeschool.model.Clienti;
import ro.mycodeschool.model.Persoana;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlPersoane {

    private ArrayList<Persoana> listapersoane;

    private String path;

    public ControlPersoane(String path) {

        listapersoane = new ArrayList<>();

        this.path = path;

        load();

    }

    public void add(Persoana persoana) {
        listapersoane.add(persoana);
    }

    public void load() {

        try {


            File file = new File(path);

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String linie = scanner.nextLine();

                if (linie.equals("") == false) {
                     String functie=linie.split(",")[3];

                     switch (functie){
                         case "admin":
                             listapersoane.add(new Administrator(linie));
                             break;

                         case "client":
                             listapersoane.add(new Clienti(linie));
                             break;
                     }

                }

            }


        } catch (Exception e) {

        }

    }

    public void afisare() {

        for (int i = 0; i < listapersoane.size(); i++) {
            System.out.println(listapersoane.get(i));
        }

    }

    public int getPozitie(int id) {

        for (Persoana p : listapersoane) {

            if (p.getId() == id) {
                return listapersoane.indexOf(p);
            }

        }
        return -1;

    }


    public void updateNume(int id, String nume) {

        int pozitie = getPozitie(id);

        if (pozitie != -1) {

            Persoana p = listapersoane.get(pozitie);

            p.setNume(nume);

        }

    }

    public void updatePrenume(int id, String prenume) {

        int pozitie = getPozitie(id);

        if (pozitie != -1) {

            Persoana p = listapersoane.get(pozitie);

            p.setPrenume(prenume);

        }

    }

    public void updateStatusAdm(int id, String functie) {

        int pozitie = getPozitie(id);

        if (pozitie != -1) {

            Persoana p = listapersoane.get(pozitie);

            p.setFunctie(functie);

        }

    }


    public boolean delete(int id) {

        int pozitie = getPozitie(id);

        if (pozitie != -1) {

            listapersoane.remove(pozitie);

            return true;

        }

        return false;

    }

    public void metodaInstanta() {

        for (Persoana p : listapersoane) {

            if (p instanceof Clienti) {
                ((Clienti) p).medodaClient();
            } else if (p instanceof Administrator) {
                ((Administrator) p).metodaAdmn();
            }

        }

    }

    public void afiseazaStatus() {

        int clienti = 0;
        int admini = 0;

        for (Persoana p : listapersoane) {

            if (p instanceof Clienti) {
                System.out.println("test");
                clienti++;

            } else if (p instanceof Administrator) {
                admini++;
            }
        }
        System.out.println(String.format("Clienti: %d, Administratori: %d", clienti, admini));
    }

    public void sortByName() {
        for (int i = 0; i < listapersoane.size(); i++) {
            for (int j = i + 1; j < listapersoane.size(); j++) {

                if (listapersoane.get(i).getNume().compareTo(listapersoane.get(j).getNume()) > 0) {
                    Persoana aux = listapersoane.get(i);
                    listapersoane.set(i, listapersoane.get(j));
                    listapersoane.set(j, aux);
                }

            }
        }
    }

    public void save() {

        try {

            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(this);

            printWriter.close();

        } catch (Exception e) {

        }
    }

    public Persoana login(String email, String parola) {

        for (Persoana p : listapersoane) {

            if (p.getEmail().equals(email) && p.getParola().equals(parola)) {
                return p;
            }
        }
        return null;
    }


    public Persoana inregistrare(String nume, String prenume, String parola) {

        Persoana newPersoana = inregistrare(nume, prenume, parola);

        newPersoana.toString();

        return newPersoana;

    }

    @Override
    public String toString() {
        String text = "";

        for (Persoana p : listapersoane) {
            text += p + "\n";
        }
        return text;
    }


    public int getSize() {
        return listapersoane.size();
    }

    public void clear() {
        listapersoane.clear();
    }

    public int nextId(){

        if (listapersoane.size()>0){

            return listapersoane.get(listapersoane.size()-1).getId()+1;
        }
        return 1;
    }


}
