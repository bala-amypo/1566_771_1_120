package com.example.demo.service.impl;

import com.example.demo.entity.KeyExemption;
import com.example.demo.repository.KeyExemptionRepository;
import com.example.demo.service.KeyExemptionService;
import org.springframework.stereotype.Service;

@Service
public class KeyExemptionServiceImpl implements KeyExemptionService {

    private final KeyExemptionRepository repo;

    public KeyExemptionServiceImpl(KeyExemptionRepository repo) {
        this.repo = repo;
    }

    @Override
    public void addExemption(String apiKey) {
        if (!repo.existsByApiKey(apiKey)) {
            KeyExemption ex = new KeyExemption();
            ex.setApiKey(apiKey);
            repo.save(ex);
        }
    }

    @Override
    public void removeExemption(String apiKey) {
        repo.deleteByApiKey(apiKey);
    }

    @Override
    public boolean isExempted(String apiKey) {
        return repo.existsByApiKey(apiKey);
    }
}
