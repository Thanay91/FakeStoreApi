package org.scaler.fakestor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
