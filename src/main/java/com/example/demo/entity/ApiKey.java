package com.example.demo.service;

import com.example.demo.entity.ApiKey;

public interface ApiKeyService {
    ApiKey create(Long userId);
    ApiKey get(String apiKey);
}
