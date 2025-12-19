package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ApiKeyService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApiKeyServiceImpl implements ApiKeyService {

    private final ApiKeyRepository apiKeyRepo;
    private final UserRepository userRepo;

    public ApiKeyServiceImpl(ApiKeyRepository apiKeyRepo, UserRepository userRepo) {
        this.apiKeyRepo = apiKeyRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ApiKey create(Long userId) {
        UserAccount user = userRepo.findById(userId).orElseThrow();
        ApiKey key = new ApiKey();
        key.setApiKey(UUID.randomUUID().toString());
        key.setUser(user);
        return apiKeyRepo.save(key);
    }

    @Override
    public ApiKey get(String apiKey) {
        return apiKeyRepo.findByApiKey(apiKey).orElseThrow();
    }
}
