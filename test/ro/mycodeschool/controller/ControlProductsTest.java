package ro.mycodeschool.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

   assertEquals(1234.23,controlProducts.updatePret(1,1234.23));

    }

    @Test
    public void updateStoc(){
      assertEquals(10,controlProducts.updateStock(1,10));
    }
    @Test
    public void updateModel(){
     assertEquals("seria 7",controlProducts.updateModel(1,"seria 7"));
    }

    @Test
    public void updateNume(){

        assertEquals("my laptop",controlProducts.updateNume(1,"my laptop"));

    }

    @Test
    public void testSterge(){
        controlProducts.afisare();

        assertEquals(true,controlProducts.sterg("A15"));

        assertEquals(false,controlProducts.sterg("A13"));

    }

    @Test
    public void numarInstanteTest(){

        assertEquals(true,controlProducts.getSize()>0);
    }

    @Test
    public void afiseazaLaptopTest(){

        controlProducts.afiseazaLaptop();

        assertEquals(true,controlProducts.getSize()>0);
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