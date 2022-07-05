package com.karakurt.homework3.DataAccess.Product;

import com.karakurt.homework3.Entities.Product.IProduct;
import com.karakurt.homework3.Entities.Product.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductDao implements IProductDao {

    public static List<IProduct> randomProducts;

    public ProductDao(){
        controlRandomProducts();
    }

    @Override
    public List<IProduct> getProductList() {
        int randomOrderNumber = new Random().nextInt(10) + 3;
        randomProducts = randomProducts.stream().limit(randomOrderNumber).toList();
        return randomProducts;
    }

    public List<IProduct> getRandomProducts() {
        Random random = new Random();
        List<IProduct> randomProducts = new ArrayList<>();
        randomProducts.add(new Product(1L,"Jeans",random.nextDouble(90) + 20));
        randomProducts.add(new Product(2L,"Jacket",random.nextDouble(90) + 20));
        randomProducts.add(new Product(3L,"Poncho",random.nextDouble(90) + 20));
        randomProducts.add(new Product(4L,"Cravat",random.nextDouble(40) + 5));
        randomProducts.add(new Product(5L,"Belt",random.nextDouble(65) + 10));
        randomProducts.add(new Product(6L,"Cheesecake",random.nextDouble(70) + 40));
        randomProducts.add(new Product(7L,"Burritos",random.nextDouble(90) + 50));
        randomProducts.add(new Product(8L,"Sandwich",random.nextDouble(30) + 20));
        randomProducts.add(new Product(9L,"Calzone",random.nextDouble(110) + 80));
        randomProducts.add(new Product(10L,"Chicken",random.nextDouble(70) + 40));
        randomProducts.add(new Product(11L,"Asus",random.nextDouble(400) + 200));
        randomProducts.add(new Product(12L,"Lenovo",random.nextDouble(400) + 200));
        randomProducts.add(new Product(13L,"Iphone",random.nextDouble(400) + 200));
        randomProducts.add(new Product(14L,"Samsung",random.nextDouble(400) + 200));
        randomProducts.add(new Product(15L,"Casper",random.nextDouble(400) + 200));
        return randomProducts;
    }

    @Override
    public IProduct createProduct(String name, Double price) {
        controlRandomProducts();
        Long id = Long.valueOf(randomProducts.size() + 1);
        IProduct iProduct = new Product(id, name, price);
        randomProducts.add(iProduct);
        return iProduct;
    }

    @Override
    public IProduct updateProduct(Long id, String name, Double price) {
        controlRandomProducts();
        IProduct iProduct = randomProducts.get(Math.toIntExact(id - 1));
        iProduct.setName(name);
        iProduct.setPrice(price);
        randomProducts.remove(Math.toIntExact(id - 1));
        randomProducts.add(Math.toIntExact(id - 1), iProduct);
        return iProduct;
    }

    @Override
    public void deleteProduct(Long id) {
        controlRandomProducts();
        randomProducts.remove(Math.toIntExact(id - 1));
    }

    public void setRandomProducts(List<IProduct> randomProductList) {
        randomProducts = randomProductList;
    }

    public void controlRandomProducts(){
        if (randomProducts == null){
            List<IProduct> randomProductList = getRandomProducts();
            setRandomProducts(randomProductList);
        }
    }
}
