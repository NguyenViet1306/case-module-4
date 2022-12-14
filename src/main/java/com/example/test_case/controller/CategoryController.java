package com.example.test_case.controller;

import com.example.test_case.model.Brand;
import com.example.test_case.model.Category;
import com.example.test_case.service.IBrandService;
import com.example.test_case.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/categories")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping
    private ResponseEntity<List<Category>> findAll() {
        return new ResponseEntity<>(iCategoryService.findAll(), HttpStatus.OK);
    }
}
