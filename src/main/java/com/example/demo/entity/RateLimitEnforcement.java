package com.example.demo.service;

public interface RateLimitEnforcementService {
    void validate(String apiKey);
}
