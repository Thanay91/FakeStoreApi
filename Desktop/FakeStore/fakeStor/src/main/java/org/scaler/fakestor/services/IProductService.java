package org.scaler.fakestor.services;

import org.scaler.fakestor.dto.RequestDTO;
import org.scaler.fakestor.models.Product;

import java.util.List;

public interface IProductService {
    public Product getSingleProduct(Long id);

    public List<Product> getAllProducts();

    public Product replaceProduct(Long id, RequestDTO requestDTO);
}
