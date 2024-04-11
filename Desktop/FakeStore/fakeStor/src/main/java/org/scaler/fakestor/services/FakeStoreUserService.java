package org.scaler.fakestor.services;


import org.scaler.fakestor.dto.UserResponseDTO;
import org.scaler.fakestor.models.Address;
import org.scaler.fakestor.models.Geolocation;
import org.scaler.fakestor.models.Name;
import org.scaler.fakestor.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service

public class FakeStoreUserService implements IUserService {
    RestTemplate restTemplate;
    @Autowired
    public FakeStoreUserService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    public User getUserFromUserResponseDTO(UserResponseDTO userResponseDTO){
        User user = new User();
        user.setId(userResponseDTO.getId());
        Address address = new Address();
        address.setCity(userResponseDTO.getAddress().getCity());
        Geolocation geoLocation = new Geolocation();
        geoLocation.setLat(userResponseDTO.getAddress().getGeolocation().getLat());
        //geoLocation.setLongi(userResponseDTO.getAddress().getGeolocation().getLongi());
        address.setGeolocation(geoLocation);
        address.setNumber(userResponseDTO.getAddress().getNumber());
        address.setStreet(userResponseDTO.getAddress().getStreet());
        address.setZipcode(userResponseDTO.getAddress().getZipcode());
        user.setAddress(address);
        user.setUserName(userResponseDTO.getUsername());
        user.setEmail(userResponseDTO.getEmail());
        user.setPhone(userResponseDTO.getPhone());
        Name name = new Name();
        user.setLastName(userResponseDTO.getName().getLastname());
        user.setFirstName(userResponseDTO.getName().getFirstname());

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        UserResponseDTO[] response =  restTemplate.getForObject("https://fakestoreapi.com/users", UserResponseDTO[].class);
        for(UserResponseDTO users:response){
            allUsers.add(getUserFromUserResponseDTO(users));

        }
        return allUsers;

    }

    @Override
    public User addUser(User user) {
        return null;
    }
}
