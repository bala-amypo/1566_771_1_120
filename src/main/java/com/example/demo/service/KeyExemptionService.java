package com.example.demo.service;

public interface KeyExemptionService {
    void addExemptipackage com.example.demo.service;

import com.example.demo.entity.KeyExemption;
import java.util.List;

public interface KeyExemptionService {
    KeyExemption createExemption(KeyExemption e);
    KeyExemption updateExemption(Long id, KeyExemption e);
    KeyExemption getExemptionByKey(Long apiKeyId);
    List<KeyExemption> getAllExemptions();
}
on(String apiKey);
    void removeExemption(String apiKey);
    boolean isExempted(String apiKey);
}
