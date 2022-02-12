package com.innova.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductDto {

    private Long productId;
    private String productName;
    private double productPrice;

}
