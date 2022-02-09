package com.odev.solid.solid;

import lombok.Data;

@Data
public abstract class Bird {

    private String genusName;
    private String speciesName;
    private double weight;
    private double height;
    private double length;

    public abstract double getWingspan();
    public abstract String makeFamily();
}
