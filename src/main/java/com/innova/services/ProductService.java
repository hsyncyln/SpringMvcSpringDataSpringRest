package com.innova.services;

import com.innova.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
}
