package com.odev.solid.notsolid;

public class BirdManager {

    public static Chicken getChicken(){
        return new Chicken();
    }

    public static Eagle getEagle(){
        return new Eagle();
    }

    /*
    Oluşturulan her kuş sınıfı için metot yazılmamalı.
    Open-Closed Principle (OCP) 
     */
}
