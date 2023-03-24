package com.survivalcoding.library.domain.repository;

import java.util.List;
import com.survivalcoding.library.domain.model.User;

public interface UserRepository {
    // CRUD
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    List<User> findAll();

    User findById(int id);

    User findByName(String name);

    // ...
}
