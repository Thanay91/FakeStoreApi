package org.scaler.fakestor.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {

    @OneToMany(mappedBy = "category")
    private List<Product> products;
    private String name;
}
