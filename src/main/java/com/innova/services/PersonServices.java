package com.innova.services;

import com.innova.dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonServices {

    //http://localhost:8090/rest/manuelJson
    @GetMapping("/rest/manuelJson")
    public String getManuelJson(){
        return "{\"adisoyadi\":\"Huseyin Ceylan\" }";
    }

    //http://localhost:8090/rest/dynamicJson
    @GetMapping("/rest/dynamicJson")
    public ProductDto getDynamicJson(){

        ProductDto productDto = new ProductDto().builder()
                .productId(0L).productName("Kalem")
                .productPrice(15).build();

        return productDto;
    }

    //http://localhost:8090/rest/mediatype
    @GetMapping(value = "/rest/mediatype",produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto getMediaType(){

        ProductDto productDto = new ProductDto().builder()
                .productId(0L).productName("Silgi")
                .productPrice(10).build();

        return productDto;
    }

    //http://localhost:8090/rest/pathvariable/kitap
    @GetMapping(value = "/rest/pathvariable/{urunAdi}")
    public ProductDto getPathVariable(
            @PathVariable("urunAdi") String urunAdi
    ){

        ProductDto productDto = new ProductDto().builder()
                .productId(0L).productName(urunAdi)
                .productPrice(10).build();

        return productDto;
    }

    //http://localhost:8090/rest/productlist
    @GetMapping(value = "/rest/productlist")
    public List<ProductDto> getProductList(){

        List<ProductDto> productDtoList = new ArrayList<>();
        ProductDto productDto = new ProductDto().builder()
                .productId(0L).productName("urunAdi")
                .productPrice(10).build();

        productDtoList.add(productDto);
        productDtoList.add(productDto);
        productDtoList.add(productDto);
        productDtoList.add(productDto);

        return productDtoList;
    }
}
