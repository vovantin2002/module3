package com.example.bai_4.repository;

import com.example.bai_4.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    //id, tên sản phẩm, giá sản phẩm, mô tả của sản phẩm, nhà sản xuất.
    static {
        productList.add(new Product(1, "iphone", 1000, "ok", "vovantin"));
        productList.add(new Product(2, "dell", 1200, "ok", "vovantin"));
        productList.add(new Product(3, "lenovo", 1500, "ok", "vovantin"));
        productList.add(new Product(4, "macbook pro", 2000, "ok", "vovantin"));
        productList.add(new Product(5, "samsum", 900, "ok", "vovantin"));
    }

    @Override
    public List<Product> display() {
        return productList;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public Product showProductUpdate(int id) {
        Product product = null;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                product = productList.get(i);
                break;
            }
        }
        return product;
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.set(i, product);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
                break;
            }
        }
    }

    @Override
    public Product detail(int id) {
        Product product = null;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                product = productList.get(i);
                break;
            }
        }
        return product;
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> productList1 = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(name)) {
                productList1.add(productList.get(i));
            }
        }
        return productList1;
    }
}
