package com.karakurt.homework3.DataAccess.Product;

import com.karakurt.homework3.Entities.Product.IProduct;

import java.util.List;

public interface IProductDao {
    List<IProduct> getProductList();
    IProduct createProduct(String name, Double price);
    IProduct updateProduct(Integer id, String name, Double price);
    void deleteProduct(Integer id);
}
