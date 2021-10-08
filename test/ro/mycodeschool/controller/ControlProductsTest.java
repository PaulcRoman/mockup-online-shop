package ro.mycodeschool.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.mycodeschool.controller.ControlProducts;
import ro.mycodeschool.model.Product;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ControlProductsTest {

    ControlProducts controlProducts;

    @BeforeEach
    public void initiere(){
        controlProducts = new ControlProducts(Path.of("test","ro","mycodeschool","productTest").toString());
    }

    @Test
    public void controlProduct(){

//        controlProducts.load();

        controlProducts.afisare();

        assertEquals(true, controlProducts.getSize()>0);

    }

    @Test
    public void testadd(){

        Product produs = new Product(1,"laptop","HP","vision",2,2345.2);

        controlProducts.add(produs);

        controlProducts.afisare();


    }

    @Test
    public void updatePrice(){

        controlProducts.updatePret(1,2200);
        controlProducts.afisare();

    }

    @Test
    public void updateStoc(){
        controlProducts.updateStock(1,4);
        controlProducts.afisare();
    }
    @Test
    public void updateModel(){
        controlProducts.updateModel(3,"Dell");
        controlProducts.afisare();
    }

    @Test
    public void updateNume(){
        controlProducts.updateNume(2,"Alien Ware");
        controlProducts.afisare();
    }

    @Test
    public void testSterge(){
        controlProducts.delete(1);

        assertEquals(0, controlProducts.getId(1));

        controlProducts.afisare();
    }

    @Test
    public void numarInstanteTest(){

        controlProducts.numarInstante();
    }

    @Test
    public void afiseazaLaptopTest(){

        controlProducts.afiseazaLaptop();
    }

    @Test
    public void afiseazaMobilTest(){

        controlProducts.afiseazaMobil();
    }

    @Test
    public void returneazaProdusTest(){

        System.out.println(controlProducts.returneazaProdus("apple","iphone13"));
        System.out.println(controlProducts.returneazaProdus("samsung", "A15"));


    }

}