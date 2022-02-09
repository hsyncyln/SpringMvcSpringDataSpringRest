# 4.Hafta-05.02.2022-06.02.2022-Ödevler

MVC yapısında thymeleaf kullanılarak bir register sayfası oluşturulacak, sonra entity bileşeni oluşturulup databaseye eklenecek (Pazartesi'ye kadar)

SOLID'e çalışılacak ve SOLID prensipleri ile ilgili Java kodları yazılıp github'a yüklenecek. Ayrıca Powerpoint sunusu hazırlanacak. (11.02.2021 Cuma'ya kadar)												
Register ödevi geliştirilecek (thymeleaf kullanılacak ve bootstrap ile iyileştirilecek) ve ders sonundaki örnekte REST olarak datalar gösterilecek (11.02.2021 Cuma'ya kadar)		

-------------------------------------------

SOLID Ödeviyle İlgili PDF'i Code'un içerisinde bulabilirsiniz.

-------------------------------------------

User Message Form Template (Register Ödevi)

1) Mesaj Ekleme Formu

![Screenshot_3](https://user-images.githubusercontent.com/14879304/153303240-a97df3f2-67eb-4b3a-8f9c-c21ec645a6f1.png)

2) Aksiyon başarılı mesajı

![Screenshot_4](https://user-images.githubusercontent.com/14879304/153303270-0b32cabc-788b-4de1-9600-ee8cff3bd504.png)

3) Mesaj Düzenleme Formu / Mesaj Silme Aksiyonu

![Screenshot_2](https://user-images.githubusercontent.com/14879304/153303392-08109986-deb1-4a8e-9e00-d37e7e3d3c9a.png)

4) Aksiyon gerçekleştirilemedi mesajı

![Screenshot_1](https://user-images.githubusercontent.com/14879304/153303569-670d982b-13c0-4d18-9a73-720eba109daa.png)

5) Mesaj Bulma (Görüntüleme) Formu - Editleme Yapılamaz

![Screenshot_5](https://user-images.githubusercontent.com/14879304/153303666-7efb7970-949d-414a-82dd-b3a99de1005a.png)



# Teknolojiler
* Java 11
* Spring Boot DevTools
* Lombok
* Spring Configuration Processor
* Spring Web
* Thymeleaf
* Spring Data JPA
* H2 Database
* MySQL Driver
* Validation
* Spring Boot Actuator

### Reference Documentation

* [Github Permalink](https://github.com/hsyncyln/SpringMvcSpringDataSpringRest)

### Dependency

  <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

