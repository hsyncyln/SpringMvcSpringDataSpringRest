package com.innova.services;

import com.innova.dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductService {

    @GetMapping(value = "/rest/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public List<ProductDto> getXmlList(){

        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(ProductDto.builder().productId(0L).productName("Ürün 1").productPrice(5000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("Ürün 2").productPrice(5000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("Ürün 3").productPrice(5000).build());

        return productDtoList;
    }
}
