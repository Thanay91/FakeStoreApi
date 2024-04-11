package org.scaler.fakestor.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Geolocation extends BaseModel {
    private String lat;
    private String longi;
}
