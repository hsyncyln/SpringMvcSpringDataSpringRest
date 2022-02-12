package com.innova.services;

import com.innova.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
public class PostmanService {

    //http://localhost:8090/rest/postman/dynamicJson
    @GetMapping("/rest/postman/dynamicJson")
    public ProductDto getDynamicJson(){

        ProductDto productDto = new ProductDto().builder()
                .productId(0L).productName("Kalem")
                .productPrice(15).build();

        return productDto;
    }
    //http://localhost:8090/rest/postman/mediatype
    @GetMapping(value = "/rest/postman/mediatype",produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto getMediaType(){

        ProductDto productDto = new ProductDto().builder()
                .productId(0L).productName("Silgi")
                .productPrice(10).build();

        return productDto;
    }

    //http://localhost:8090/rest/postman/pathvariable/kitap
    @GetMapping(value = "/rest/postman/pathvariable/{urunAdi}")
    public ProductDto getPathVariable(
            @PathVariable("urunAdi") String urunAdi
    ){

        ProductDto productDto = new ProductDto().builder()
                .productId(0L).productName(urunAdi)
                .productPrice(10).build();

        return productDto;
    }

    //http://localhost:8090/rest/postman/productlist
    @GetMapping(value = "/rest/postman/productlist")
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

    ///////////// POST //////////////
// -->Tarayıcıda bu hatayla karşılaştık, POSTMAN ile çalışıyor.

    //    There was an unexpected error (type=Method Not Allowed, status=405).
//    Request method 'GET' not supported
//    org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'GET' not supported
//
    //http://localhost:8090/rest/post/postman
    @PostMapping(value = "/rest/post/postman")
    public ProductDto postProduct(ProductDto productDto){
        ProductDto productDto1 = productDto;
        log.info(productDto1);
        return productDto1;
    }

    ///////////// PUT //////////////

//    There was an unexpected error (type=Method Not Allowed, status=405).
//    Request method 'GET' not supported
//    org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'GET' not supported

    //http://localhost:8090/rest/put/postman
    @PutMapping(value = "/rest/put/postman")
    public ProductDto updateProduct(ProductDto productDto){
        ProductDto productDto1 = productDto;
        log.info(productDto1);
        return productDto1;
    }

    /////////// DELETE /////////////

    //http://localhost:8090/rest/delete/postman/2
    @DeleteMapping(value = "/rest/delete/postman/{id}")
    public void deleteProduct(@PathVariable(name="id") Long id){
        log.info( id + " -> id silindi");
    }


}
