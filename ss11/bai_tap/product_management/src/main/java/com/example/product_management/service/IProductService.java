package com.example.product_management.service;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void delete(int id);
    void update(Product product);
    Product findById(int id);
    List<Product> findByName(String name);
}

