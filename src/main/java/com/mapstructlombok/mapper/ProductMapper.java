package com.mapstructlombok.mapper;

import com.mapstructlombok.dto.GetProduct;
import com.mapstructlombok.entity.Product;
import org.mapstruct.*;

import javax.swing.*;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            /*@Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),*/
            @Mapping(source = "creationDate", target = "creationDate",
                    dateFormat = "yyyy-MM-dd HH-mm-ss"),
            @Mapping(source = "name", target = "productName"),
            @Mapping(source = "id", target = "productId"),
            @Mapping(source = "category", target = "productCategory"),
            @Mapping(source = "price", target = "price", numberFormat = "$0.00"),

    })

    GetProduct toGetDTO(Product product);

    @Mappings({
            @Mapping(target = "creationDate", ignore = true)
    })

    @InheritInverseConfiguration
    Product toEntity(GetProduct getProduct);

    List<GetProduct> toGetProductList(List<Product> productList);

    List<Product> toEntityList(List<GetProduct> getProductList);

}
