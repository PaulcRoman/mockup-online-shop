package ro.mycodeschool.view;

import ro.mycodeschool.controller.ControlOrder;
import ro.mycodeschool.controller.ControlOrderDetails;
import ro.mycodeschool.controller.ControlPersoane;
import ro.mycodeschool.controller.ControlProducts;
import ro.mycodeschool.model.*;

import javax.swing.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewUser {

    private ControlProducts controlProducts;

    private ControlOrderDetails controlOrderDetails;

    private ControlPersoane controlPersoane;

    private ControlOrder controlOrder;

    private Clienti clienti;

    private Scanner scanner;

    private Order order;


    public ViewUser(Clienti clienti) {

        controlProducts = new ControlProducts(Path.of("src", "ro", "mycodeschool", "produse.txt").toString());

       controlOrderDetails = new ControlOrderDetails(Path.of("src", "ro", "mycodeschool", "orderDetails").toString());

        controlPersoane = new ControlPersoane(Path.of("src", "ro", "mycodeschool", "persoane").toString());

        controlOrder = new ControlOrder(Path.of("src", "ro", "mASDAScodeschool", "orders").toString());

        this.clienti = clienti;

        scanner = new Scanner(System.in);

        order= new Order(controlOrder.nextId(),clienti.getId(),0,clienti.getPrenume(),"12.12.13");



    }

    public void meniu() {

        System.out.println("============Meniu User===============");
        System.out.println("Apasati tasta 1 a afisa produsele ");

        System.out.println("Apasati tasta 2 pentru a adauga un produs");

        System.out.println("Apasati tasta 3 pt a vizualiza produsele din cos");

        System.out.println("Apasati tasta 4 pentru a edita cosul");

        System.out.println("Apasati tasta 5 pentru vizualiza pretul total");

        System.out.println("Apasati tasta 6 pentru a cumpara");

        System.out.println("Apasati tasta 0 pentru a iesi din meniu");


    }

    public void play() {

        boolean running = true;

        while (running == true) {
            meniu();

            int alegere = Integer.parseInt((scanner.nextLine()));

            switch (alegere) {

                case 1:
                    controlProducts.afisare();
                    break;

                case 2:
                    addCos();
                    break;
                case 3:
                    vizualizareCos();
                    break;

                case 4:
                    editareCos();
                    break;

                case 5:
                    pretTotalCos();
                    break;

                case 6:
                    buy();
                    break;

                case 0:
                    System.out.println("La revedere");
                    running = false;
                    break;

            }
        }

    }

    public void addCos() {

        System.out.println("Introduceti marca");
        String  marca = scanner.nextLine();
        System.out.println("Introduceti modelul");
        String model = scanner.nextLine();

       Product p = controlProducts.returneazaProdus(marca, model);

        if(p!=null) {

            System.out.println(p);
            System.out.println("Introduceti cantitatea ");
            int quantity = Integer.parseInt(scanner.nextLine());
            //verificam cantitatea

            if(quantity<p.getStock()){

                OrderDetails orderDetails =  new OrderDetails(controlOrderDetails.nextId(),order.getId(),p.getId(),p.getPret()*quantity,quantity);

                controlProducts.updateStock(p.getId(),p.getStock()-quantity);

                controlOrderDetails.add(orderDetails);

                System.out.println("Produsul este adaugat in cos");

            }else{

                System.out.println("cantitatea introdusa nu este disponibila");
            }

        }

    }

    public void vizualizareCos(){

        ArrayList <OrderDetails> details=controlOrderDetails.getAllOrderDetails(order.getId());

        for(OrderDetails orderDetails :details){

            Product p=controlProducts.returneazaProdus(orderDetails.getProductId());

            String  text="";
            text+="Marca "+p.getMarca()+"\n";
            text+="Model  "+p.getModel()+"\n";
            text+="Cantiatate "+orderDetails.getQuantity()+"\n";
            text+="Pret "+orderDetails.getPrice()+"\n";
            System.out.println(text);
        }

    }

    public void editareCos(){

        System.out.println("Intoroduceti marca si modelul produsului pe care doriti sa il modificati");

        System.out.println("Introduceti marca");
        String marca = scanner.nextLine();
        System.out.println("Introduceti modelul");
        String model = scanner.nextLine();

        Product p = controlProducts.returneazaProdus(marca,model);

       if (p!=null){

           ArrayList<OrderDetails> detalii= controlOrderDetails.getAllOrderDetails(this.order.getId());

           OrderDetails orderD=null;

           for(OrderDetails d:detalii){

                if(d.getProductId()==p.getId()){

                     orderD=d;
                }
           }

           if(orderD!=null){

               System.out.println("Introduceti cantitatea");

               int cantitate =Integer.parseInt(scanner.nextLine());

               controlOrderDetails.updateQuantity(orderD.getId(), cantitate);

           }
           System.out.println(p);

        }
    }

    public void pretTotalCos(){

        ArrayList<OrderDetails> order = controlOrderDetails.getAllOrderDetails(this.order.getId());

        double pret = 0;
        for (OrderDetails od : order){

            pret += od.getPrice();

        }

        System.out.println(pret);

    }

    public void buy(){

        controlOrderDetails.save();
        controlOrder.add(order);
        controlOrder.save();

        System.out.println("Achizitia a fost procesata!");


    }

}
