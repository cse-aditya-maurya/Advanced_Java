
package com.springmvc.demo.dao;

import com.springmvc.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAO {

    public List<Product> getAllProducts() {

        List<Product> productList = new ArrayList<>();

        // Creating products inside DAO
        productList.add(new Product(1, "Laptop", 65000));
        productList.add(new Product(2, "Mobile", 25000));
        productList.add(new Product(3, "Headphones", 3000));

        return productList;
    }
}