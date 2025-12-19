package com.example.demo.service;

public interface KeyExemptionService {
    void addExemption(String apiKey);
    void removeExemption(String apiKey);
    boolean isExempted(String apiKey);
}
