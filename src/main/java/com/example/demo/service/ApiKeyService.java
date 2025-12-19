package com.example.demo.service;

import com.example.demo.entity.ApiKey;

public interface ApiKeyService {
    ApiKey createApiKey(Long userId);
    ApiKey getApiKey(String apiKey);
}
