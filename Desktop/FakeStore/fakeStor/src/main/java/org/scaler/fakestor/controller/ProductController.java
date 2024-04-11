package org.scaler.fakestor.controller;

import org.scaler.fakestor.dto.ErrorResponseDTO;
import org.scaler.fakestor.dto.ProductRequestDTO;
import org.scaler.fakestor.exceptions.ProductNotFoundException;
import org.scaler.fakestor.models.Category;
import org.scaler.fakestor.models.Product;
import org.scaler.fakestor.services.SelfProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    SelfProductService productService;
    public ProductController(SelfProductService productService){
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        ResponseEntity responseEntity;
        Product product = productService.getSingleProduct(id);
        responseEntity = new ResponseEntity(product, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        ResponseEntity responseEntity = new ResponseEntity(new ArrayList<>(), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/category/{cat_name}")
    public ResponseEntity<List<Product>> getInCategory(@PathVariable("cat_name") String categoryName){
        ResponseEntity responseEntity = new ResponseEntity(new ArrayList(), HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping
    public Product addProduct(@RequestBody ProductRequestDTO productRequestDTO){

        Product product = new Product();
        product.setTitle(productRequestDTO.getTitle());
        product.setPrice(productRequestDTO.getPrice());
        product.setDescription(productRequestDTO.getDescription());
        product.setImageURL(productRequestDTO.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(productRequestDTO.getCategory());
        Product savedProduct = productService.addProduct(product);
        return savedProduct;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) throws ProductNotFoundException {
        Product product = new Product();
        product.setTitle(productRequestDTO.getTitle());
        product.setPrice(productRequestDTO.getPrice());
        product.setDescription(productRequestDTO.getDescription());
        product.setImageURL(productRequestDTO.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(productRequestDTO.getCategory());
        Product savedProduct = productService.updateProduct(product, id);
        return savedProduct;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody ProductRequestDTO productRequestDTO){
        if(productRequestDTO.getTitle()==null||
        productRequestDTO.getDescription()==null||
        productRequestDTO.getCategory()==null){
            return null;
        }

        return productService.replaceProduct(id, productRequestDTO);
    }

    @GetMapping("/category/get_by/{id}")
    public ResponseEntity<Product> getProductByCategory_Id (@PathVariable("id") Long id) throws ProductNotFoundException{
        ResponseEntity responseEntity;
        Product product = productService.getProductByCategory_Id(id);
        responseEntity = new ResponseEntity(product, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id){
        return true;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage(productNotFoundException.getMessage() + " Response generated at control level");
        ResponseEntity responseEntity = new ResponseEntity(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        return  responseEntity;
    }


}
