package com.java.generics;

import java.util.List;

public class MainApp {
    static void main() {
        // Instantiate for Product
        InMemoryRepository<Product> productRepo = new InMemoryRepository<>();

        // Save
        productRepo.save(new Product("P001", "Laptop"));
        productRepo.save(new Product("P002", "Monitor"));

        // Find
        productRepo.findById("P001").ifPresent(p -> System.out.println("Found: " + p));

        // Find All
        List<Product> allProducts = productRepo.findAll();
        System.out.println("Total count: " + allProducts.size());
        System.out.println("All products: " + allProducts);
    }

}
