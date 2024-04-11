package org.scaler.fakestor.services;

import org.scaler.fakestor.models.User;

import java.util.List;

public interface IUserService {
    public List<User> getAllUsers();

    public User addUser(User user);
}
