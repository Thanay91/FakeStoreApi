package org.scaler.fakestor.services;

import org.scaler.fakestor.FakeStorApplication;
import org.scaler.fakestor.dto.RequestDTO;
import org.scaler.fakestor.dto.ResponseDTO;
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


    public Product getProductFromResponseDTO(ResponseDTO responseDTO){
        Product product = new Product();
        product.setId(responseDTO.getId());
        product.setTitle(responseDTO.getTitle());
        product.setDescription(responseDTO.getDescription());
        product.setPrice(responseDTO.getPrice());
        product.setCategory(new Category());
        product.getCategory().setName(responseDTO.getCategory());
        product.setImageURL(responseDTO.getImage());
        return product;
    }
    @Override
    public Product getSingleProduct(Long id) {
        //hit FakeStore Api, and get product
        ResponseDTO responseDTO =  restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                ResponseDTO.class);
        //parse the response, and convert it into product class.

       Product product = getProductFromResponseDTO(responseDTO);
       return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        ResponseDTO[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products", ResponseDTO[].class);

        for(ResponseDTO responseDTO: response){
            allProducts.add(getProductFromResponseDTO(responseDTO));
        }
        return allProducts;
    }

    @Override
    public Product replaceProduct(Long id, RequestDTO requestDTO) {
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(ResponseDTO.class);
        HttpMessageConverterExtractor<ResponseDTO> responseExtractor = new HttpMessageConverterExtractor(ResponseDTO.class, restTemplate.getMessageConverters());
        ResponseDTO responseDTO =  restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);
        return getProductFromResponseDTO(responseDTO);
    }
}
