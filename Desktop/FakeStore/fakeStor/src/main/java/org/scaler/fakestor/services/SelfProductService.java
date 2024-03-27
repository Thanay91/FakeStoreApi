package org.scaler.fakestor.services;

import org.scaler.fakestor.dto.RequestDTO;
import org.scaler.fakestor.exceptions.ProductNotFoundException;
import org.scaler.fakestor.models.Category;
import org.scaler.fakestor.models.Product;
import org.scaler.fakestor.repositories.CategoryRepository;
import org.scaler.fakestor.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Primary
@Qualifier("SelfProductService")
public class SelfProductService implements IProductService {
    CategoryRepository categoryRepository;
    ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product getProductByCategory_Id(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.getProductByCategory_Id(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("The product with " + id + " does not exist");
        }
        Product product = optionalProduct.get();
        return product;
    }

    @Override
    public Product addProduct(Product product) {
        Optional<Category> optionalCategory = categoryRepository.findByName(product.getCategory().getName());
        Category savedCategory;
        if(optionalCategory.isEmpty()){
            Category category = new Category();
            category.setName(product.getCategory().getName());
            savedCategory = categoryRepository.save(category);
        } else{
            savedCategory = optionalCategory.get();
        }
        product.setCategory(savedCategory);
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    @PatchMapping("/{id}")
    public Product updateProduct(Product product, @PathVariable("id") Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id "+ id +" doesnot exist, cant update product");
        }
        Product existingProduct = optionalProduct.get();
        Product productToBeSaved = new Product();

        productToBeSaved.setTitle(
                product.getTitle() != null ?
                        product.getTitle():existingProduct.getTitle()
        );

        productToBeSaved.setPrice(
                product.getPrice() > 0 ?
                        product.getPrice():existingProduct.getPrice()
        );

        productToBeSaved.setDescription(
                product.getDescription() != null ?
                        product.getDescription():existingProduct.getDescription()
        );

        productToBeSaved.setImageURL(
                product.getImageURL() != null ?
                        product.getImageURL():existingProduct.getImageURL()
        );

        if(product.getCategory().getName() != null){
            Optional<Category> optionalCategory = categoryRepository.findByName(product.getCategory().getName());
            Category savedCategory;
            if(optionalCategory.isEmpty()){
                Category category = new Category();
                category.setName(product.getCategory().getName());
                savedCategory = categoryRepository.save(category);
            }
            else{
                savedCategory = optionalCategory.get();
            }
            productToBeSaved.setCategory(savedCategory);
        }
        else{
            productToBeSaved.setCategory(existingProduct.getCategory());
        }
        productToBeSaved.setId(id);
        return productRepository.save(productToBeSaved);
    }

    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("The product with " + id + " does not exist");
        }
        Product product = optionalProduct.get();
        return product;

    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, RequestDTO requestDTO) {
        return null;
    }
}
