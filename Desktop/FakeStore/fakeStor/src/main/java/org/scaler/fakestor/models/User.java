package org.scaler.fakestor.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel{

    //U  :  A
    //1  :  1
    //M   :  1

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private String email;
    private String userName;
    private String firstName;
    private String lastName;
    private String phone;

}
