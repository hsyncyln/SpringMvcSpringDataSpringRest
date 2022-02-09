package com.odev.solid.notsolid;

import java.util.*;

public class MainTest {
    public static void main(String[] args) {

        //Liskov's Substitution Principle
        List<Bird> birds = new ArrayList<Bird>() ;
        birds.add(new Chicken());
        birds.add(new Eagle());

        Chicken chicken = BirdManager.getChicken();

    }
}
