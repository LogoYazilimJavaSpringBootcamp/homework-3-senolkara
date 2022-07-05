package com.karakurt.homework3.RestAPI;

import com.karakurt.homework3.Business.Product.IProductService;
import com.karakurt.homework3.Entities.Product.IProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-api")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService iProductService;

    @GetMapping
    public List<IProduct> getProductList(){
        return this.iProductService.getProductList();
    }

    @PostMapping
    public IProduct createProduct(String name, Double price){
        return this.iProductService.createProduct(name, price);
    }

    @PatchMapping("{id}")
    public IProduct updateProduct(@PathVariable Long id, String name, Double price){
        return this.iProductService.updateProduct(id, name, price);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        this.iProductService.deleteProduct(id);
    }
}
