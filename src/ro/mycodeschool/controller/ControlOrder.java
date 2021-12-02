package ro.mycodeschool.controller;

import ro.mycodeschool.model.Order;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Formattable;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class ControlOrder {

    private ArrayList<Order> orderList;

    private String path;

    public ControlOrder(String path) {

        orderList = new ArrayList<>();
        this.path = path;
        load();
    }

    public void add(Order order) {
        orderList.add(order);
    }

    public void load() {

        orderList.clear();

        try {


            File file = new File(path);

            Scanner scanner = new Scanner(file);

            String linie = "";

            while (scanner.hasNextLine()) {


                linie = scanner.nextLine();

                if (linie.equals("")==false) {

                    orderList.add(new Order(linie));
                }



            }


        } catch (Exception e) {

        }
    }

    public void afisare() {
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.get(i));
        }
    }

    public int getPozitie(int id) {

        for (Order order : orderList) {

            if (order.getCustomerId() == id) {
                return orderList.indexOf(order);

            }
        }
        return -1;
    }



    public void updateShippingAddress(int id, String shippingAddress) {

        int index = getPozitie(id);

        if (index != -1) {

            Order order = orderList.get(index);

            order.setShippingAddress(shippingAddress);
        }
    }

    public Order getOrder(int id){

        int pozitie = getPozitie(id);

        if (pozitie != -1){

           return orderList.get(pozitie);
        }
        return null;

    }

    public double updateAmount(int id, double amount) {
        int pozitie = getPozitie(id);

        if (pozitie != -1) {

            Order order = orderList.get(pozitie);

            order.setAmount(amount);
        }
        return amount;
    }
//
//    public void updateQuantity(int id, int quantity){
//        int pozitie = getPozitie(id);
//
//        if (pozitie != -1){
//
//            Order order = orderList.get(pozitie);
//
//            order.s
//        }
//    }

    public String  updateDate(int id, String date) {
        int pozitie = getPozitie(id);

        if (pozitie != -1) {

            Order order = orderList.get(pozitie);

            order.setDate(date);
        }
        return date;
    }

    public void save(){

        try {


            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(this);
            printWriter.close();

        }catch (Exception e){

        }
    }

    public void delete(int id) {

        int pozitie = getPozitie(id);
        if (pozitie != -1) {
            orderList.remove(pozitie);
        }else {
            System.out.println("Order inexistent");
        }

    }

    public void sortByCustId() {
        for (int i = 0; i < orderList.size(); i++) {
            for (int j = i+1; j<orderList.size();j++){

                if (orderList.get(i).getCustomerId() == orderList.get(j).getCustomerId()){

                    Order aux = orderList.get(i);
                    orderList.set(i, orderList.get(j));
                    orderList.set(j, aux);
                }
            }

        }
    }

    @Override
    public String toString(){
        String text = "";

        for (Order order : orderList){
            text += order+"\n";

        }
        return text;
    }


    public int nextId(){

        if(orderList.size()>0){


            return  orderList.get(orderList.size()-1).getCustomerId()+1;
        }

        return 1;
    }

    public int getSize(){
        return orderList.size();
    }


}
