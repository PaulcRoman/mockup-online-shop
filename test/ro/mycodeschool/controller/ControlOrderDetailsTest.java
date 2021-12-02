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
        OrderDetails orderDetails = new OrderDetails("1,4,4,5.1123,1");
        controlOrderDetails.add(orderDetails);
        controlOrderDetails.afisare();

    }

    @Test
    public void testGetPozitie(){

        for (int i =0; i<5; i++){

            controlOrderDetails.add(new OrderDetails("13,13,13,231.22,13"));
            assertEquals(true,controlOrderDetails.getPozitie(13)>=0);

        }

        for (int i = 0; i<5; i++){
            controlOrderDetails.deleteOrder(13);
            assertEquals(true,controlOrderDetails.getPozitie(13)>=-1);
        }
    }

    @Test
    public void testUpdateId(){

        assertEquals(4,controlOrderDetails.updateProductId(2,4));

    }

    @Test
    public void testUpdatePrice(){

        assertEquals(222.22, controlOrderDetails.updatePrice(2,222.22));

    }

    @Test
    public void updateQuantity(){

        assertEquals(100,controlOrderDetails.updateQuantity(1,100));
    }

    @Test
    public void deleteOrder(){

        controlOrderDetails.deleteOrder(1);
        controlOrderDetails.afisare();
    }

    @Test
    public void saveTest(){

        controlOrderDetails.add(new OrderDetails("4,4,4,4.444,2"));
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