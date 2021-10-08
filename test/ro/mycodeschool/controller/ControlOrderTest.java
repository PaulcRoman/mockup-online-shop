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

//        Order x = new Order("3,3,4321,strada garoafei 4, 2 Octombrie,2021");
//
//
//        System.out.println(x);

    }

    @Test
    public void updateShippingAddressTest(){

        controlOrder.updateShippingAddress(1,"strada libertatii 2");
        controlOrder.afisare();
    }


}