package com.odev.solid.solid;

public class IChickenFactory implements IBirdAbstractFactory{
    @Override
    public Bird getInstance() {
        return new Chicken();
    }
}
