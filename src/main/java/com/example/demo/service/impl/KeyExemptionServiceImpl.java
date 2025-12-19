package com.example.demo.service.impl;

import com.example.demo.entity.KeyExemption;
import com.example.demo.repository.KeyExemptionRepository;
import com.example.demo.service.KeyExemptionService;
import org.springframework.stereotype.Service;

@Service
public class KeyExemptionServiceImpl implements KeyExemptionService {

    private final KeyExemptionRepository repository;

    public KeyExemptionServiceImpl(KeyExemptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addExemption(String apiKey) {
        if (!repository.existsByApiKey(apiKey)) {
            KeyExemption ex = new KeyExemption();
            ex.setApiKey(apiKey);
            repository.save(ex);
        }
    }

    @Override
    public void removeExemption(String apiKey) {
        repository.deleteByApiKey(apiKey);
    }

    @Override
    public boolean isExempted(String apiKey) {
        return repository.existsByApiKey(apiKey);
    }
}
