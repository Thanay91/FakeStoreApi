package org.scaler.fakestor.repositories;

import org.scaler.fakestor.models.Product;
import org.scaler.fakestor.projections.ProductWithIdTitlePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Optional<Product> findById(Long id);

    @Query("select p from Product p where p.category.id = ?1")
    public Optional<Product> getProductByCategory_Id(Long Id);

    Product save(Product product);

    @Query("select p.id as id, p.price as price, p.title as title from Product p")
    public List<ProductWithIdTitlePrice> something();

}
