package com.innova.services;

import com.innova.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
public class ProductService {

    @GetMapping(value = "/rest/xml",produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public List<ProductDto> getXmlList(){

        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(ProductDto.builder().productId(0L).productName("Ürün 1").productPrice(5000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("Ürün 2").productPrice(5000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("Ürün 3").productPrice(5000).build());

        return productDtoList;
    }

    @GetMapping(value = "/rest/json",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ProductDto> getJsonList(){

        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(ProductDto.builder().productId(0L).productName("Ürün 1").productPrice(5000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("Ürün 2").productPrice(5000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("Ürün 3").productPrice(5000).build());

        return productDtoList;
    }

    ////
    //POST

    @PostMapping("post/basic")
    public void postBasic(@RequestBody ProductDto dto){
        log.info(dto);
    }

    @PostMapping("post/productDto")
    public void postProduct(@RequestBody ProductDto dto){
        log.info(dto);
    }


    ///////////////////////
    //PUT
    @PutMapping("put/productdto")
    public ProductDto putProduct( @RequestBody ProductDto productDto){
        log.info(productDto);
        //database
        return  productDto;
    }

    ///////////////////////
    //DELETE

    @DeleteMapping("delete/productdto/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        log.info("RestController -> Silinen dto id'si : " + id);
    }

    ///////////////////////
    //STATUS CODE
    //http://localhost:8090/rest/status1
    @GetMapping("/rest/status1")
    public ResponseEntity<ProductDto> getStatus1(){
        ProductDto productDto = ProductDto.builder()
                .productId(0L).productName("Telefon 11")
                .productPrice(6000).build();

        //Hatasız çalışıyorsa ==> OK
        //return new ResponseEntity<>(productDto, HttpStatus.OK);
        //return ResponseEntity.status(HttpStatus.OK).body(productDto);
        return ResponseEntity.ok().body(productDto);
    }
    //http://localhost:8090/rest/notfound/status2/0
    @GetMapping("/rest/notfound/status2/{id}")
    public ResponseEntity<?> getStatus2(@PathVariable(name = "id") Long id){
        ProductDto productDto = ProductDto.builder().productId(id)
                .productName("Telefon 11").productPrice(6000).build();

        if(productDto.getProductId() == 0) {
            // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kayıt bulunamadı..");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Kayıt bulundu..." + productDto);
    }

    //http://localhost:8090/rest/badrequest/status3/0
    @GetMapping("/rest/badrequest/status3/{id}")
    public ResponseEntity<?> getStatus3(@PathVariable(name = "id") Long id){
        ProductDto productDto = ProductDto.builder().productId(id)
                .productName("Telefon 11").productPrice(6000).build();

        if(productDto.getProductId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Kayıt bulundu..." + productDto);
    }

    //http://localhost:8090/rest/notfound/ok4/0
    @GetMapping("/rest/notfound/ok4/{id}")
    public ResponseEntity<?> getStatus4(@PathVariable(name = "id") Long id){
        ProductDto productDto = ProductDto.builder().productId(id)
                .productName("Telefon 2").productPrice(7000).build();

        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK)
                .contentType(new MediaType("application","json"
                        , Charset.forName("UTF-8"))).body("Tamamdır.");
    }
}
