package com.karakurt.homework3.Business.Product;

import com.karakurt.homework3.DataAccess.Product.IProductDao;
import com.karakurt.homework3.Entities.Product.IProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductDao iProductDao;

    @Override
    public List<IProduct> getProductList() {
        return this.iProductDao.getProductList();
    }

    @Override
    public IProduct createProduct(String name, Double price) {
        return this.iProductDao.createProduct(name, price);
    }

    @Override
    public IProduct updateProduct(Integer id, String name, Double price){
        return this.iProductDao.updateProduct(id, name, price);
    }

    @Override
    public void deleteProduct(Integer id){
        this.iProductDao.deleteProduct(id);
    }
}
