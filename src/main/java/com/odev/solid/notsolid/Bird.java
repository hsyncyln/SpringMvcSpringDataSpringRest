package com.odev.solid.notsolid;

import lombok.Data;

@Data
public abstract class Bird {
    private String genusName;
    private String speciesName;
    private double weight;
    private double height;
    private double length;
    private double flightDistance;
    /*
        Uçuş mesafesi uçabilen kuşlar için geçerlidir. Bu yüzden Chicken classında dummy code oluşur
        Base classdaki tüm özellikler derived classlarda kullanılmalıdır. --> Liskov's Substitution Principle
     */
    public abstract double getWingspan();

    //Pek mantıklı bir örnek olmasa da bu şekilde olması solide aykırıdır. Bu durumdan kaçınmakta fayda var
    //Base class derived classlara bağımlı. Derived classta oluşan değişikliklerde base'i değiştirmek gerekebilir.
    // Bağımlılıkların olabildiğince az olması gerekiyor -->  Dependency Inversion Principle (DIP)
    private Chicken chicken = new Chicken();
    private Eagle eagle = new Eagle();

    public String makeFamily(Bird bird){
        return chicken + " ve " + eagle + " bir ailedir.";
    }
}
