package org.scaler.fakestor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    private Long id;
    private String title;
    private String category;
    private String description;
    private double price;
    private String image;
}
