package com.karakurt.homework3.Entities.Product;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product implements IProduct, Serializable {
    private Long id;
    private String name;
    private Double price;
}
