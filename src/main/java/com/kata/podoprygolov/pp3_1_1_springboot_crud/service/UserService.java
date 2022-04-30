package com.kata.podoprygolov.pp3_1_1_springboot_crud.service;

import com.kata.podoprygolov.pp3_1_1_springboot_crud.model.User;
import com.kata.podoprygolov.pp3_1_1_springboot_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findByID(int id) {
        return repository.getById(id);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
