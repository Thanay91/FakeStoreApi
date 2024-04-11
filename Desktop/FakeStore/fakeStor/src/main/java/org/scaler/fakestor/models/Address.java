package org.scaler.fakestor.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address  extends  BaseModel{

    @OneToOne
    @JoinColumn(name = "geolocation_id")
    private Geolocation geolocation;
    private String city;
    private String street;
    private String number;
    private String zipcode;
}
