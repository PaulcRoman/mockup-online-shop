package ro.mycodeschool.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.mycodeschool.model.Persoana;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlPersoanaTest {

    ControlPersoane controlPersoana;

    @BeforeEach
    public void initiere() {
        controlPersoana = new ControlPersoane(Path.of("test", "ro", "mycodeschool", "persoaneTest.txt").toString());
    }

    @Test
    public void testLogin() {

        controlPersoana.afisare();

//
//        assertEquals("aemail@email.com", controlPersoana.login("aemail@email.com", "parola3").getEmail());
//        assertEquals(null, controlPersoana.login("aaemail@email.com", "parola3"));
//
//        assertEquals("parola3", controlPersoana.login("aemail@email.com", "parola3").getParola());

    }

    @Test
    public void testLogin2() {

//        controlPersoana.add(new Persoana("Alex,Ciobanu,true,alemail@email.com, parola9,"));
//        controlPersoana.save();
//        controlPersoana.afisare();
////        assertEquals("alemail@email.com", controlPersoana.login("alemail@email.com", "parola3").getEmail());
////        assertEquals("parola9", controlPersoana.login("alemail@email.com", "parola9").getParola());
//
//        controlPersoana.clear();
//        controlPersoana.afisare();
//        assertEquals(null, controlPersoana.login("alemail@email.com", "parola9"));

    }

    @Test
    public void testLogin3() {

//        assertEquals("parola3", controlPersoana.login("aemail@email.com", "parola3").getParola());
//        assertEquals(null, controlPersoana.login("aemail@email.com", "parola"));
//        assertEquals("aemail@email.com", controlPersoana.login("aemail@email.com","parola3").getEmail());


    }

    @Test
    public void testDeelete(){
//        assertEquals(true, controlPersoana.delete("aemail@email.com"));
//        controlPersoana.afisare();
    }

    @Test
    public void testAfiseazaStatus(){
        controlPersoana.afiseazaStatus();
    }


    @AfterEach
    void postConditie() {

        controlPersoana.clear();

        controlPersoana.add(new Persoana("1,Vasile,Ionescu,client,vemail@email.com,parola1"));
        controlPersoana.add(new Persoana("2,Ion,Vasilescu,client,iemail@email.com,parola2"));
        controlPersoana.add(new Persoana("3,Andrei,Ciobanu,admin,aemail@email.com,parola3"));
        controlPersoana.add(new Persoana("4,Ducu,Bertu,client,demail@email.com,parola4"));
        controlPersoana.save();
    }



}
