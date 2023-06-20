package com.example.bai_4.service;

import com.example.bai_4.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> display();

    void create(Product product);

    Product showProductUpdate(int id);

    void update(Product product);

    void delete(int id);

    Product detail(int id);

    List<Product> searchProductByName(String name);
}
