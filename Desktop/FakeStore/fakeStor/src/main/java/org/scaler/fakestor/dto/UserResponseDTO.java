package org.scaler.fakestor.dto;

import lombok.Getter;
import lombok.Setter;
import org.scaler.fakestor.models.Address;
import org.scaler.fakestor.models.Name;

@Getter
@Setter
public class UserResponseDTO {
    private Address address;
    private Long id;
    private String email;
    private String username;
    private Name name;
    private String phone;
}
