package com.karakurt.homework3.Entities.Product;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product implements IProduct {
    private Integer id;
    private String name;
    private Double price;
}
