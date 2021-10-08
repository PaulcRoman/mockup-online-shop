package ro.mycodeschool;

import ro.mycodeschool.model.Administrator;
import ro.mycodeschool.model.Clienti;
import ro.mycodeschool.model.Persoana;
import ro.mycodeschool.view.ViewUser;

public class Application {

    public static void main(String[] args) {


        ViewUser viewUser  = new ViewUser(new Clienti("4,Ducu,Bertu,client,demail@email.com,parola4"));


        viewUser.play();



    }
}
