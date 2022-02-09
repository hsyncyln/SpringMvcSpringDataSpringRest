package com.odev.solid.notsolid;

//Single Responsiblity - Nesnenin sadece bir sorumluluğu olmaludır
//Interface Segregation - Nesnelerin ihtiyaç duymadıkları Interface’lerinden mümkün olduğunca ayrıştırılmasıdır.
public interface IFly {

    //Uçuş Mesafesi
    public double getFlightDistance();

    //Vahşi Doğadaki Dövüş Gücü
    public int getFightForceInTheWild();

    /*
    Uçabilen tüm kuşlar vahşi doğada yaşamazlar.                                         --> Interface Segregation - ILiveInTheWild
    IFly interface'i vahşi doğadaki dövüş gücünü barındırmamalı.Uçmak ile alakası yok    --> Single Responsibility - ILiveInTheWild
     */

}
