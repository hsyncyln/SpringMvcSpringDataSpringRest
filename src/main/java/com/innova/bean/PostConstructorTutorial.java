package com.innova.bean;

import lombok.Data;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Data
@ToString
public class PostConstructorTutorial {

    @Autowired
    Logger logger;

    @PostConstruct
    public void init(){
        logger.info("Bu da yazdırılmaz ancak hata da vermez");
    }

//    public PostConstructorTutorial() {
//        System.out.println("Parametresiz constructor");
//        logger.info("Bu yazdırılmayacak log hala boş. Null hatası verir");
//    }

    public static void main(String[] args) {
        PostConstructorTutorial post = new PostConstructorTutorial();
        System.out.println(post);
    }
}
