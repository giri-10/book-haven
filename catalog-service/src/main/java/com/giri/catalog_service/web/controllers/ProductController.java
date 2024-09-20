package com.giri.catalog_service.web.controllers;

import com.giri.catalog_service.domain.ProductEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    List<Product> getProducts(@RequestParam(name="page", defaultValue = 1) int page) {
        return productService.getProducts();
    }
}
