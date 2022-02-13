package com.innova.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class _03_BeanInitialDestroy {

// @Scope("request")   // sadece Tek istekte  atıldığında yaşar ve ölür
// @Scope("session")   // oturum kapatıldığında ölür
// @Scope("prototype") // Clone oluşurur başlarken 2 tanedir
    @Scope("singleton") // Default olandır proje başlarken Init ve destroy çalışır default olandır projeyi kapattığımda ölür
    @Bean(initMethod = "initialBeanMethod",destroyMethod = "destroyBeanMethod")
    public BeanDto beanInitialDestroy() {
        return BeanDto.builder().id(0L).beanData("Data pro").beanName("Adı pro").build();
    }

}