package org.scaler.fakestor.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String title;
    private  String description;
    private double price;
    private String imageURL;

    //P  :  C
    //1  : 1
    //M  :  1
    @ManyToOne(cascade = {CascadeType.ALL})
    private Category category;

    private int qty_available;
    private int qty_sold;


}
