package ro.mycodeschool.controller;

import ro.mycodeschool.model.Laptop;
import ro.mycodeschool.model.Mobile;
import ro.mycodeschool.model.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlProducts {

    private ArrayList<Product> listaProduse;
    String path;


    public ControlProducts(String path) {
        listaProduse = new ArrayList();
        this.path = path;
        load();
    }

    public void add(Product product) {
        listaProduse.add(product);
    }

    public void load() {


        try {

            File file = new File(path);

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String linie = scanner.nextLine();

                switch (linie.split(",")[1]) {

                    case "laptop":
                        listaProduse.add(new Laptop(linie));
                        break;

                    case "mobil":
                        listaProduse.add(new Mobile(linie));
                        break;
                }

            }


        } catch (Exception e) {


        }
    }

    public void afisare() {
        for (int i = 0; i < listaProduse.size(); i++) {
            System.out.println(listaProduse.get(i));
        }
    }

    public int getId(int id) {

        for (Product p : listaProduse) {
            if (p.getId() == id) {
                return listaProduse.indexOf(p);
            }
        }
        return -1;

    }

    public void getModelProdus(String model) {

        for (Product p : listaProduse) {

            if (p instanceof Mobile && p instanceof Laptop) {
                if (p.getModel().equals(model)) {

                    System.out.println("Produsul " + model + " a fost introdus in cos");
                } else {
                    System.out.println("inexistent");
                }
            }
        }
    }
    public void updatePret(int id, double pret) {

        int index = getId(id);

        if (index != -1) {

            Product p = listaProduse.get(index);

            p.setPret(pret);

        } else {
            System.out.println("Erro");
        }


    }

    public void updateStock(int id, int stock) {

        int pozitie = getId(id);

        if (pozitie != -1) {

            Product p = listaProduse.get(pozitie);

            p.setStock(stock);
        } else {
            System.out.println("Error");
        }

    }

    public void updateModel(int id, String model) {
        int index = getId(id);

        if (index != -1) {

            Product p = listaProduse.get(index);

            p.setMarca(model);
        } else {
            System.out.println("Erro");
        }

    }

    public void updateNume(int id, String nume) {

        int index = getId(id);

        if (index != -1) {

            Product p = listaProduse.get(index);

            p.setCategorie(nume);

        } else {
            System.out.println("Error");
        }
    }


    public void delete(int id) {

        int index = getId(id);

        if (index != -1) {
            listaProduse.remove(id);
        } else {
            System.out.println("Produsul introdus nu exista");
        }
    }

    public void numarInstante() {

        int laptop = 0, mobile = 0;

        for (Product p : listaProduse) {

            if (p instanceof Laptop) {
                laptop++;
            } else if (p instanceof Mobile) {
                mobile++;
            }

        }
        System.out.println(String.format("Laptops: %d, Mobiles: %d", laptop, mobile));

    }

    public String afiseazaLaptop() {

        for (Product p : listaProduse) {

            if (p instanceof Laptop) {

                if (p != null) {

                    System.out.println(p);
                }
            }
        }
        return null;
    }

    public String afiseazaMobil(){

        for (Product p : listaProduse){

            if (p instanceof  Mobile){

                if (p != null){
                    System.out.println(p);
                }
            }
        }
        return null;
    }

    public void afiseazaModelLaptop(){

        String model = afiseazaLaptop();

        if (model != null){

            switch (model){
                case "aus":
                    getModelProdus(model);
                    break;
                case "hp":
                    getModelProdus(model);
                    break;


            }
        }

    }

    public void updateConfig(int id, String config) {

        int index = getId(id);

        if (index != -1) {

            Product p = listaProduse.get(index);

            if (p instanceof Laptop) {
                ((Laptop) p).setConfiguratie(config);
            }

        }

    }

    public Product returneazaProdus(String marca ,String model){


       for (Product p : listaProduse){

           if (p.getMarca().equals(marca) && p.getModel().equals(model)){

               return p;
           }

       }
       return null;

    }
    public Product returneazaProdus(int id){


        for (Product p : listaProduse){

            if (p.getId()==id){

                return p;
            }

        }
        return null;

    }

    public void updateOperator(int id, String operator) {

        int index = getId(id);

        if (index != -1) {

            Product p = listaProduse.get(index);

            if (p instanceof Mobile) {
                ((Mobile) p).setOperator(operator);
            }

        }
    }

    @Override
    public String toString() {

        String text = "";

        for (Product p : listaProduse) {

            text += p + "\n";

        }

        return text;

    }

    public int getSize() {
        return listaProduse.size();
    }

    public void clear() {
        listaProduse.clear();
    }


    public int nextId() {

        if (listaProduse.size() > 0) {

            return listaProduse.get(listaProduse.size() - 1).getId() + 1;
        }
        return 1;
    }


}
