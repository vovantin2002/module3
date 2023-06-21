package com.example.bai_4.service;

import com.example.bai_4.model.Product;
import com.example.bai_4.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> display() {
        return productRepository.display();
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public Product showProductUpdate(int id) {
        return productRepository.showProductUpdate(id);
    }

    @Override
    public boolean update(Product product) {
        boolean flag=productRepository.update(product);
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag=productRepository.delete(id);
        return flag;
    }

    @Override
    public Product detail(int id) {
        return productRepository.detail(id);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return productRepository.searchProductByName(name);
    }
}
