package com.shubham.springactuatorapp.controller;

import com.shubham.springactuatorapp.entity.Employee;
import com.shubham.springactuatorapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/v1/spring-actuator")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(productService.getAllEmployee());
    }
}
