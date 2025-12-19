package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    private final UserRepository repo;

    public AuthServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    public UserAccount register(String username, String password) {
        UserAccount u = new UserAccount();
        u.setUsername(username);
        u.setPassword(password);
        return repo.save(u);
    }
}
