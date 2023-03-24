package com.survivalcoding.library.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.survivalcoding.library.domain.model.User;
import com.survivalcoding.library.domain.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    private Data<User> data;
    
    private List<User> users = new ArrayList<>();
    
    public UserRepositoryImpl() {
        
    }
    
    public UserRepositoryImpl(Data<User> data) {
        this.data = data;
    }

    @Override
    public void addUser(User user) {
        Optional<User> findUser = users.stream().filter(e -> e.getId() == user.getId()).findFirst();

        if (!findUser.isEmpty()) {
            throw new IllegalArgumentException("동일한 ID가 존재합니다");
        }
        users.add(user);
        
        // File, Cloud, Db
        if (data != null) {
            data.save(users);
        }
    }

    @Override
    public void updateUser(User user) {
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            User e = users.get(i);
            if (e.getId() == user.getId()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            users.set(index, user);
            if (data != null) {
                data.save(users);
            }
        }
    }

    @Override
    public void deleteUser(User user) {
        users.remove(user);
        if (data != null) {
            data.save(users);
        }
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(int id) {
//        Optional<User> user = users.stream().filter(e -> e.getId() == id).findFirst();
//        if (!user.isEmpty()) {
//            return user.get();
//        } 
//        return null;
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            user = users.get(i); 
            if (user.getId() == id) {
                break;
            }
        }
        return user;
    }

    @Override
    public User findByName(String name) {
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            user = users.get(i); 
            if (user.getName().equals(name)) {
                break;
            }
        }
        return user;
    }

}








