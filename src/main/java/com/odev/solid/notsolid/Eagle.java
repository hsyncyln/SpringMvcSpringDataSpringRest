package com.odev.solid.notsolid;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Eagle extends Bird implements IFly {


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

}
