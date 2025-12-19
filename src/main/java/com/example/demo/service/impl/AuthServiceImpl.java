package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.AutoService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AutoService {

    private final UserAccountRepository repository;

    public AuthServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount register(String username, String password) {
        UserAccount user = new UserAccount();
        user.setUsername(username);
        user.setPassword(password);
        return repository.save(user);
    }
}
