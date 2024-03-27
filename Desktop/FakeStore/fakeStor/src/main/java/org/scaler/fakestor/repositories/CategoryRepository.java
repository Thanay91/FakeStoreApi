package org.scaler.fakestor.repositories;

import org.scaler.fakestor.models.Category;
import org.scaler.fakestor.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findById(Long id);

    Optional<Category> findByName(String name);

    Category save(Category category);
}
