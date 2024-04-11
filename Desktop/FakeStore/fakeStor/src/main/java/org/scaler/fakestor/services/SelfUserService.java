package org.scaler.fakestor.services;

import jakarta.persistence.Entity;
import lombok.Setter;
import org.scaler.fakestor.dto.UserRequestDTO;
import org.scaler.fakestor.models.User;
import org.scaler.fakestor.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Primary
@Qualifier("SelfUserService")
public class SelfUserService implements IUserService{
    UserRepository userRepository;

    @Autowired
    public SelfUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User addUser(User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
