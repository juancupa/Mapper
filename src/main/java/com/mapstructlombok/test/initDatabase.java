package com.mapstructlombok.test;

import com.mapstructlombok.dto.GetProduct;
import com.mapstructlombok.entity.Product;
import com.mapstructlombok.mapper.ProductMapper;
import com.mapstructlombok.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class initDatabase {

private  ProductMapper productMapper;
    private final ProductRepository productRepository;
    @Bean
    public CommandLineRunner testProductMapperCommand(){

        return args -> {
            List<Product> products = productRepository.findAll();

            System.out.println("Products");
            products.forEach(System.out :: println);


        };
    }
}
