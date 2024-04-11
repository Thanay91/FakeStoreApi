package org.scaler.fakestor.dto;

import lombok.Getter;
import lombok.Setter;
import org.scaler.fakestor.models.Address;
@Getter
@Setter
public class UserRequestDTO {

    private String email;
    private String userName;
    private String firstName;
    private String lastName;
    private String phone;
    private String city;
    private String street;
    private String number;
    private String zipcode;
    private String lat;
    private String longi;
}
