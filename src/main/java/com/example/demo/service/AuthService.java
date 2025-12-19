package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface AutoService {
    UserAccount register(String username, String password);
}
