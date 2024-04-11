package org.scaler.fakestor.services;

import org.scaler.fakestor.dto.ProductRequestDTO;
import org.scaler.fakestor.dto.ProductResponseDTO;
import org.scaler.fakestor.exceptions.ProductNotFoundException;
import org.scaler.fakestor.models.Category;
import org.scaler.fakestor.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService{
    public RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    public Product getProductFromResponseDTO(ProductResponseDTO productResponseDTO){
        Product product = new Product();
        product.setId(productResponseDTO.getId());
        product.setTitle(productResponseDTO.getTitle());
        product.setDescription(productResponseDTO.getDescription());
        product.setPrice(productResponseDTO.getPrice());
        product.setCategory(new Category());
        product.getCategory().setName(productResponseDTO.getCategory());
        product.setImageURL(productResponseDTO.getImage());
        return product;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        //hit FakeStore Api, and get product
        ProductResponseDTO productResponseDTO =  restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                ProductResponseDTO.class);
        if(productResponseDTO ==null){
            throw new ProductNotFoundException("Product with id " + id + " does not exist");
        }
        //parse the response, and convert it into product class.
       Product product = getProductFromResponseDTO(productResponseDTO);
       return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        ProductResponseDTO[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products", ProductResponseDTO[].class);

        for(ProductResponseDTO productResponseDTO : response){
            allProducts.add(getProductFromResponseDTO(productResponseDTO));
        }
        return allProducts;
    }

    @Override
    public Product replaceProduct(Long id, ProductRequestDTO productRequestDTO) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(productRequestDTO, ProductResponseDTO.class);
        HttpMessageConverterExtractor<ProductResponseDTO> responseExtractor = new HttpMessageConverterExtractor(ProductResponseDTO.class, restTemplate.getMessageConverters());
        ProductResponseDTO productResponseDTO =  restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);
        return getProductFromResponseDTO(productResponseDTO);
    }

    @Override
    public Product getProductByCategory_Id(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        return null;
    }
}
