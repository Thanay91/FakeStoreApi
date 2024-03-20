package org.scaler.fakestor.controller;

import org.scaler.fakestor.dto.RequestDTO;
import org.scaler.fakestor.models.Category;
import org.scaler.fakestor.models.Product;
import org.scaler.fakestor.services.FakeStoreProductService;
import org.scaler.fakestor.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;
    public ProductController(FakeStoreProductService productService){
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return new ArrayList<>();
    }

    @GetMapping("/category/{cat_name}")
    public List<Product> getInCategory(@PathVariable("cat_name") String categoryName){
        return new ArrayList<>();
    }

    @PostMapping
    public Product addProduct(@RequestBody RequestDTO requestDTO){
        return new Product();
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody RequestDTO requestDTO){
        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody RequestDTO requestDTO ){
        if(requestDTO.getTitle()==null||
        requestDTO.getDescription()==null||
        requestDTO.getCategory()==null){
            return null;
        }
        return productService.replaceProduct(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id){
        return true;
    }
}
