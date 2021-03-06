package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByUserName(String userName);

    User getUserById(Long id);

    User saveAndFlush(User user);

  //  boolean userIsExisting(User user);

}


