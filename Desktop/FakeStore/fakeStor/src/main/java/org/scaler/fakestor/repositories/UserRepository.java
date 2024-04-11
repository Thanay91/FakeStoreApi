package org.scaler.fakestor.repositories;

import org.scaler.fakestor.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    public List<User> findAll();

    User save(User user);
}
