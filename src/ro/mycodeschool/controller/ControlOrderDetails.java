package ro.mycodeschool.controller;

import ro.mycodeschool.model.Order;
import ro.mycodeschool.model.OrderDetails;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlOrderDetails {

    private ArrayList<OrderDetails> orderDetailsList;

    private String path;

    public ControlOrderDetails(String path) {
        orderDetailsList = new ArrayList<>();
        this.path = path;
        load();
    }

    public void add(OrderDetails orderDetails) {
        orderDetailsList.add(orderDetails);
    }

    public void load() {

        try {

            File file = new File(path);
            Scanner scanner = new Scanner(file);

            String linie = "";

            while (scanner.hasNextLine()) {

                linie = scanner.nextLine();

                orderDetailsList.add(new OrderDetails(linie));

            }


        } catch (Exception e) {

        }

    }

    public void afisare() {

        for (int i = 0; i < orderDetailsList.size(); i++) {
            System.out.println(orderDetailsList.get(i));
        }
    }

    public int getPozitie(int id) {

        for (OrderDetails od : orderDetailsList) {

            if (od.getOrderId() == id) {
                return orderDetailsList.indexOf(od);
            }
        }
        return -1;

    }

    public void updateProductId(int id, int productID){
        int index = getPozitie(id);

        if (index != -1){

             OrderDetails od = orderDetailsList.get(index);

             od.setProductId(productID);

        }
    }

    public void updatePrice(int id, double price){
        int index = getPozitie(id);

        if (index != -1){

            OrderDetails od = orderDetailsList.get(index);

            od.setPrice(price);

        }
    }

    public void updateQuantity(int id, int quantity){
        int index = getPozitie(id);

        OrderDetails od = orderDetailsList.get(index);

        od.setQuantity(quantity);
    }

    

    public void deleteOrder(int id){
        int index = getPozitie(id);

        orderDetailsList.remove(index);

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

    public void sortByPrice(){
        for (int i = 0; i< orderDetailsList.size();i++){
            for (int j = i+1; j< orderDetailsList.size();j++){

                if (orderDetailsList.get(i).getPrice() > orderDetailsList.get(j).getPrice()){

                    OrderDetails aux = orderDetailsList.get(i);

                    orderDetailsList.set(i, orderDetailsList.get(j));

                    orderDetailsList.set(j, aux);
                }
            }
        }
    }

    @Override
    public String toString(){

        String text = "";

        for (OrderDetails od : orderDetailsList){

            text += od+"\n";
        }
        return text;


    }

    public void clear(){
        orderDetailsList.clear();
    }

    public int getSize(){
       return orderDetailsList.size();
    }


    public int nextId(){

        if (orderDetailsList.size()>0){

            return orderDetailsList.get(orderDetailsList.size()-1).getOrderId()+1;
        }
        return 1;
    }


    public  ArrayList<OrderDetails> getAllOrderDetails(int orderId){


         ArrayList<OrderDetails> orders= new ArrayList<>();
         for (OrderDetails orderDetails :orderDetailsList){

              if(orderDetails.getOrderId()==orderId){

                  orders.add(orderDetails);
              }
         }

         return  orders;
    }

    public ArrayList<OrderDetails> removeOrder(int orderId){

        ArrayList<OrderDetails>orders = new ArrayList<>();
        for (OrderDetails orderDetails : orderDetailsList){

            if (orderDetails.getOrderId()==orderId){

                orders.remove(orderDetails);
            }
        }
        return orders;
    }



}
