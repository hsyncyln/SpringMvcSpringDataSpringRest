package com.odev.solid.solid;

//Tavuk uçamadığı için IFly interface'ini implemente etmemize gerek kalmadı
public class Chicken extends Bird {

    @Override
    public double getWingspan() {
        return super.getHeight() * super.getLength() / 500;
    }

    //Bu da bir bağımlılık yaratmasına rağmen base classa göre bağımlılığı daha azdır.
    @Override
    public String makeFamily() {
        return this + " ve " + new Eagle() + " bir ailedir.";
    }

}
