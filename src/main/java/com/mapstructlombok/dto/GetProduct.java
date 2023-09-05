package com.mapstructlombok.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProduct {

    private Long productId;
    private String productName;
    private String creationDate;
    private GetCategory productCategory;
    private String price;

}
