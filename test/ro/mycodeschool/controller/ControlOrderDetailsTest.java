package ro.mycodeschool.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.mycodeschool.model.Order;
import ro.mycodeschool.model.OrderDetails;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;

class ControlOrderDetailsTest {

    ControlOrderDetails controlOrderDetails;

    @BeforeEach
public void initiere(){

        controlOrderDetails = new ControlOrderDetails(Path.of("test","ro","mycodeschool","orderDetailsTest").toString());

    }

    @Test

    public void testAfisare(){

        controlOrderDetails.afisare();
    }

    @Test
    public void testLoad1(){

        assertEquals(true, controlOrderDetails.getSize()>0);
    }

    @Test
    public void testadd(){
        OrderDetails orderDetails = new OrderDetails("1,4,prod4,123.5,1");
        controlOrderDetails.add(orderDetails);
        controlOrderDetails.afisare();

    }

    @Test
    public void testUpdateId(){

        controlOrderDetails.updateProductId(2,3);
        controlOrderDetails.afisare();

    }

    @Test
    public void testUpdatePrice(){

        controlOrderDetails.updatePrice(1,123.45);
        controlOrderDetails.afisare();
    }

    @Test
    public void updateQuantity(){

        controlOrderDetails.updateQuantity(1,2);
        controlOrderDetails.afisare();
    }

    @Test
    public void deleteOrder(){

        controlOrderDetails.deleteOrder(1);
        controlOrderDetails.afisare();
    }

    @Test
    public void saveTest(){

        controlOrderDetails.add(new OrderDetails("4,prod4,1145.4,2"));
        controlOrderDetails.save();
        controlOrderDetails.afisare();
    }

    @Test
    public void sort(){

        controlOrderDetails.sortByPrice();
        controlOrderDetails.afisare();
    }



    @AfterEach
    public void postConditie(){

        controlOrderDetails.clear();

        controlOrderDetails.add(new OrderDetails("1,1,2,1200,3"));
        controlOrderDetails.add(new OrderDetails("2,2,2,1400,2"));
        controlOrderDetails.add(new OrderDetails("3,3,3,1100,1"));
        controlOrderDetails.save();
    }

}