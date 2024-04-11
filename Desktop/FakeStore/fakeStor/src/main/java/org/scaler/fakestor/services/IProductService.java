package org.scaler.fakestor.services;

import org.scaler.fakestor.dto.ProductRequestDTO;
import org.scaler.fakestor.exceptions.ProductNotFoundException;
import org.scaler.fakestor.models.Product;

import java.util.List;

public interface IProductService {
    public Product getSingleProduct(Long id) throws ProductNotFoundException;

    public List<Product> getAllProducts();

    public Product replaceProduct(Long id, ProductRequestDTO productRequestDTO);

    public Product getProductByCategory_Id(Long id) throws ProductNotFoundException;

    public Product addProduct(Product product);

    public Product updateProduct(Product product, Long id) throws ProductNotFoundException;
}
