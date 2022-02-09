package com.odev.solid.solid;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class Eagle extends Bird implements IFly,IWildAnimal {

    @Override
    public double getWingspan() {
        return super.getHeight() * super.getLength() / 100;
    }

    @Override
    public double getFlightDistance() {
        return super.getWeight() / getWingspan();
    }

    @Override
    public int getFightForceInTheWild() {
        return 9;
    }

    @Override
    public String makeFamily() {
        return new Chicken() + " ve " + this + " bir ailedir.";
    }
}
