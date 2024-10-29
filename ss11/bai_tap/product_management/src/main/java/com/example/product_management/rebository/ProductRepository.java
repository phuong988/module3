package com.example.product_management.rebository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.product_management.model.Product;

public class ProductRepository implements IProductRepository {
    private final List<Product> products = new ArrayList<>();
    private int presentId = 1;

    public ProductRepository() {
        products.add(new Product(presentId++, "Xiaomi", "xiaomi", 5000000, "7 mu khac nhau", 50));
        products.add(new Product(presentId++, "Iphone 17", "Apple", 30000000, "Thêm 1  út bấm so với iphone 16", 20));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    @Override
    public void save(Product product) {
        product.setId(presentId++);
        products.add(product);
    }

    @Override
    public void update(Product product) {
        Optional<Product> existingProductOpt = products.stream()
                .filter(p -> p.getId() == product.getId())
                .findFirst();

        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();
            existingProduct.setName(product.getName());
            existingProduct.setManufacturer(product.getManufacturer());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setQuantity(product.getQuantity());
        } else {
            throw new IllegalArgumentException("Product not found for ID: " + product.getId());
        }
    }

    @Override
    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    @Override
    public Product findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}

