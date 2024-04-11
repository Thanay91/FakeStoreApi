package org.scaler.fakestor.controller;

import org.scaler.fakestor.dto.UserRequestDTO;
import org.scaler.fakestor.models.Address;
import org.scaler.fakestor.models.Geolocation;
import org.scaler.fakestor.models.Product;
import org.scaler.fakestor.models.User;
import org.scaler.fakestor.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    public IUserService userService;
    @Autowired
    public UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    public User getSingleUser(Long Id){
        return null;
    }

    public User addUser(@RequestBody UserRequestDTO userRequestDTO){
        User user = new User();
        user.setUserName(userRequestDTO.getUserName());
        user.setPhone(userRequestDTO.getPhone());
        user.setEmail(userRequestDTO.getEmail());
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        Address address = new Address();
        address.setStreet(userRequestDTO.getStreet());
        address.setCity(userRequestDTO.getCity());
        address.setNumber(userRequestDTO.getNumber());
        address.setZipcode(userRequestDTO.getZipcode());
        Geolocation geolocation = new Geolocation();
        geolocation.setLat(userRequestDTO.getLastName());
        geolocation.setLongi(userRequestDTO.getLongi());
        address.setGeolocation(geolocation);
        user.setAddress(address);
        User savedUser = userService.addUser(user);
        return savedUser;
    }
}
