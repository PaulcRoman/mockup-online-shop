package ro.mycodeschool.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.mycodeschool.model.Order;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ControlOrderTest {

    ControlOrder controlOrder;

    @BeforeEach
public void initiere(){

        controlOrder = new ControlOrder(Path.of("test","ro","mycodeschool","ordersTest").toString());

    }

    @Test
    public void afisare(){

        controlOrder.afisare();

    }

    @Test
    public void testLoad(){

       int nr = controlOrder.getSize();

       for (int i = 0; i<100; i++){

           controlOrder.load();

       }
       controlOrder.afisare();
       assertEquals(nr,controlOrder.getSize());
    }

    @Test
    public void testLoad2(){
        int nr = controlOrder.getSize();

        for (int i=0;i<100;i++){
            controlOrder = new ControlOrder(Path.of("test","ro","mycodeschool","ordersTest").toString());
        }
        controlOrder.afisare();
        assertEquals(nr, controlOrder.getSize());
    }

//    @Test
//    public void testAdd(){
//
//        for (int i = 0; i<10; i++){
//            controlOrder.add(new Order(i+1,i+2,0.5+i,"adresa mea"+i,"Ianuarie 10"+i));
//        }
//
//        for (int i=0;i<10;i++){
//            assertEquals(true,controlOrder.getOrder(i+1)!=null);
//        }
//        controlOrder.save();
//
//    }

    @Test
    public void testUpdateAmount() {

        assertEquals(1234.23,controlOrder.updateAmount(1,1234.23));
    }

    @Test
    public void testUpdateDate(){
        assertEquals("Ianuarie 10",controlOrder.updateDate(1,"Ianuarie 10"));
    }



    @Test
    public void updateShippingAddressTest(){

        controlOrder.updateShippingAddress(1,"strada libertatii 2");
        controlOrder.afisare();
    }




}