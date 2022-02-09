package com.odev.solid.solid;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {

        //Single R. -> IFly (tek bir görevi var)

        //Open Closed -> IBirdAbstractFactory kullanılarak her kuş sınıfı için instance oluşturulabilir
        IBirdAbstractFactory chickenFactory = new IChickenFactory();
        Chicken chicken = (Chicken) chickenFactory.getInstance();
        System.out.println(chicken);

        //Liskov's Substitution Principle (üst sınıf tarafından karşılanıyor)
        List<Bird> birds = new ArrayList<Bird>() ;
        birds.add(new Chicken());
        birds.add(new Eagle());

        //Interface Segregation -> IFly ve IWildAnimal (Her interface'in kendine ait görevi vardır)

        //Dependency Inversion -> Bird sınıfındaki makeFamily methodu bir bağımlılık oluşturur



    }
}
