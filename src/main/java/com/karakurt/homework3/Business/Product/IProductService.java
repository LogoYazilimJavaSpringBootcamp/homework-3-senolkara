package com.karakurt.homework3.Business.Product;

import com.karakurt.homework3.Entities.Product.IProduct;

import java.util.List;

public interface IProductService {
    List<IProduct> getProductList();
    IProduct createProduct(String name, Double price);
    IProduct updateProduct(Long id, String name, Double price);
    void deleteProduct(Long id);
}
