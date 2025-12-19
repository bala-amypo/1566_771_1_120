package com.example.demo.service;

public interface RateLimiterService {
    void validateRequest(String apiKey);
}
