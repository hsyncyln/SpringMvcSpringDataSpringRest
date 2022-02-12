package com.innova.controller;

import com.innova.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Controller
public class ProductServicesController {

    //http://localhost:8090/client/controller/string
    @GetMapping("/client/controller/string")
    @ResponseBody
    public String getServicesStringProduct(){
        String url = "http://localhost:8090/rest/manuelJson";
        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(url,String.class);

        log.info(jsonData);

        return jsonData;
    }

    // http://localhost:8090/client/controller/productdto
    @GetMapping("/client/controller/productdto")
    @ResponseBody
    public String getProductServicesDto() {
        String URL = "http://localhost:8080/rest/dynamicsjson";
        RestTemplate restTemplate = new RestTemplate();
        ProductDto productDto = restTemplate.getForObject(URL, ProductDto.class); //object
        return "client resten veri aldı: "+productDto.getProductName().toUpperCase();
    }


    // http://localhost:8090/client/controller/special/urun44
    @GetMapping("/client/controller/productdto/special/{urun_adi}")
    @ResponseBody
    public String getProductServicesResponseEntity(@PathVariable("urun_adi") String urunAdi) {
        String URL = "http://localhost:8080/rest/pathvariable/"+urunAdi;
        RestTemplate restTemplate = new RestTemplate();
        ProductDto productDto = restTemplate.getForObject(URL, ProductDto.class);
        //Kontrol
        ResponseEntity<ProductDto> responseEntity=restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY,ProductDto.class);
        ProductDto productDto2=responseEntity.getBody();
        return "client resten veri aldı: "+productDto2;
    }

    // http://localhost:8090/client/controller/productdto/specialList
    @GetMapping("/client/controller/productdto/specialList")
    @ResponseBody
    public List<ProductDto>  getProductServicesResponseEntityList() {
        String URL = "http://localhost:8090/rest/productlist";
        RestTemplate restTemplate = new RestTemplate();
        //Anonymous Class
        ResponseEntity<List<ProductDto>> responseEntity=restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<ProductDto>>() {});
        List<ProductDto> list=responseEntity.getBody();
        for (ProductDto temp:list){
            log.info(temp);
        }
        return list;
    }

    //XML
    // http://localhost:8090/client/controller/xml
    @GetMapping(value = "/client/controller/xml",produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public List<ProductDto> getXmlList(){

        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(ProductDto.builder().productId(0L).productName("Ürün 1").productPrice(5000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("Ürün 2").productPrice(5000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("Ürün 3").productPrice(5000).build());

        return productDtoList;
    }


    ///////
    //POST
    // http://localhost:8090/client/controller/post
    @GetMapping(value = "/client/controller/post")
    @ResponseBody
    public String  postBasic(){

        ProductDto productDto = ProductDto.builder().productId(0L)
                .productName("Urun").productPrice(1000).build();

        String URL = "http://localhost:8090/post/basic";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(URL,productDto,Void.class);

        return "Success !";
    }

    // http://localhost:8090/client/controller/post/productDto?urun_adi=bilgisayar&urun_fiyati=6000
    @ResponseBody
    @GetMapping(value = "/client/controller/post/productDto")
    public String  postProductDto(@RequestParam(name = "urun_adi") String urunAdi
    ,@RequestParam(name = "urun_fiyati") double urunFiyati){

        ProductDto productDto = ProductDto.builder().productId(0L)
                .productName(urunAdi).productPrice(urunFiyati).build();

        String URL = "http://localhost:8090/post/productDto";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(URL,productDto,ProductDto.class);

        return "Success !";
    }

    // http://localhost:8090/client/controller/post/responseentity?urun_adi=bilgisayar&urun_fiyati=6000
    @ResponseBody
    @GetMapping(value = "/client/controller/post/responseentity")
    public String  postProductDtoResponseEntity(@RequestParam(name = "urun_adi") String urunAdi
            ,@RequestParam(name = "urun_fiyati") double urunFiyati){

        ProductDto productDto = ProductDto.builder().productId(0L)
                .productName(urunAdi).productPrice(urunFiyati).build();

        String URL = "http://localhost:8090/post/productDto";
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<ProductDto> productDtoHttpEntity=new HttpEntity<>(productDto);
        ResponseEntity<ProductDto> responseEntity=restTemplate.exchange(URL,HttpMethod.POST,productDtoHttpEntity,ProductDto.class);
        ProductDto productDto2=responseEntity.getBody();
        return "Success ! HttpEntity bir hata varsa almak icin: "+productDto2;
    }

    ///////////
    //PUT
    // http://localhost:8090/client/controller/put/responseentity?urun_adi=bilgisayar&urun_fiyati=6000
    @GetMapping("/client/controller/put/responseentity")
    @ResponseBody
    public String  putProductDtoResponseEntity(@RequestParam(name="urun_adi") String urunAdi,@RequestParam(name="urun_fiyati") double urunFiyati) {
        ProductDto productDto=ProductDto.builder().productId(0L).productName(urunAdi).productPrice(urunFiyati).build();
        String URL = "http://localhost:8080/put/productdto";
        RestTemplate restTemplate = new RestTemplate();
        //HttpEntity aşağıda yazdım
        ResponseEntity<ProductDto> responseEntity=restTemplate.exchange(URL,HttpMethod.PUT, new HttpEntity<ProductDto>(productDto),ProductDto.class);
        ProductDto productDto2=responseEntity.getBody();
        return "Update Success ! HttpEntity bir hata varsa almak icin: "+productDto2;
    }

}
