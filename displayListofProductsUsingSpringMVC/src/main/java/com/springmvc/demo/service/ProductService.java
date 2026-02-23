package com.springmvc.demo.service;

import com.springmvc.demo.dao.ProductDAO;
import com.springmvc.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    // Constructor Injection
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> fetchProducts() {
        return productDAO.getAllProducts();
    }
}