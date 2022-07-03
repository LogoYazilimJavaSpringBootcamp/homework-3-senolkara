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
        randomProducts.add(new Product(1,"Jeans",random.nextDouble(90) + 20));
        randomProducts.add(new Product(2,"Jacket",random.nextDouble(90) + 20));
        randomProducts.add(new Product(3,"Poncho",random.nextDouble(90) + 20));
        randomProducts.add(new Product(4,"Cravat",random.nextDouble(40) + 5));
        randomProducts.add(new Product(5,"Belt",random.nextDouble(65) + 10));
        randomProducts.add(new Product(6,"Cheesecake",random.nextDouble(70) + 40));
        randomProducts.add(new Product(7,"Burritos",random.nextDouble(90) + 50));
        randomProducts.add(new Product(8,"Sandwich",random.nextDouble(30) + 20));
        randomProducts.add(new Product(9,"Calzone",random.nextDouble(110) + 80));
        randomProducts.add(new Product(10,"Chicken",random.nextDouble(70) + 40));
        randomProducts.add(new Product(11,"Asus",random.nextDouble(400) + 200));
        randomProducts.add(new Product(12,"Lenovo",random.nextDouble(400) + 200));
        randomProducts.add(new Product(13,"Iphone",random.nextDouble(400) + 200));
        randomProducts.add(new Product(14,"Samsung",random.nextDouble(400) + 200));
        randomProducts.add(new Product(15,"Casper",random.nextDouble(400) + 200));
        return randomProducts;
    }

    @Override
    public IProduct createProduct(String name, Double price) {
        controlRandomProducts();
        Integer id = randomProducts.size() + 1;
        IProduct iProduct = new Product(id, name, price);
        randomProducts.add(iProduct);
        return iProduct;
    }

    @Override
    public IProduct updateProduct(Integer id, String name, Double price) {
        controlRandomProducts();
        IProduct iProduct = randomProducts.get(id - 1);
        iProduct.setName(name);
        iProduct.setPrice(price);
        randomProducts.remove(id - 1);
        randomProducts.add(id - 1, iProduct);
        return iProduct;
    }

    @Override
    public void deleteProduct(Integer id) {
        controlRandomProducts();
        randomProducts.remove(id - 1);
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
