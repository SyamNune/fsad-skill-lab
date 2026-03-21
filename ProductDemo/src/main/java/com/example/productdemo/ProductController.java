package com.example.productdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @PostMapping("/add")
    public String addProduct(@RequestBody Product p) {
        repo.save(p);
        return "Product added";
    }
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> getByPriceRange(@RequestParam double min,
                                         @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    @GetMapping("/sorted")
    public List<Product> getSorted() {
        return repo.findAllSortedByPrice();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> getExpensive(@PathVariable double price) {
        return repo.findExpensiveProducts(price);
    }
}