package com.odev.solid.notsolid;

//Tavuk uçamadığı için IFly interface'ini implemente etmemize gerek kalmadı
public class Chicken extends Bird  {

    @Override
    public double getWingspan() {
        return super.getHeight() * super.getLength() / 500;
    }
}
