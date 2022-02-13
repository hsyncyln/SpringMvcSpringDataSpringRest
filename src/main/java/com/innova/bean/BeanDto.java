package com.innova.bean;
import lombok.*;
import lombok.extern.log4j.Log4j2;

@Getter @Setter //POJO için sadece bu gereklidir
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class BeanDto {

    private Long id;
    private String beanName;
    private String beanData;

    //başlangıç
    public void initialBeanMethod(){
        log.info("Beanim başladı");
    }

    //bitiş
    public void destroyBeanMethod(){
        log.info("Beanim öldü");
    }
}
