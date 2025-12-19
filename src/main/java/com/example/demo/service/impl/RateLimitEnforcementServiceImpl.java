package com.example.demo.service.impl;

import com.example.demo.entity.RateLimitEnforcement;
import com.example.demo.repository.RateLimitEnforcementRepository;
import com.example.demo.service.KeyExemptionService;
import com.example.demo.service.RateLimitEnforcementService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RateLimitEnforcementServiceImpl implements RateLimitEnforcementService {

    private final RateLimitEnforcementRepository repo;
    private final KeyExemptionService exemptionService;

    public RateLimitEnforcementServiceImpl(RateLimitEnforcementRepository repo,
                                          KeyExemptionService exemptionService) {
        this.repo = repo;
        this.exemptionService = exemptionService;
    }

    @Override
    public void validate(String apiKey) {

        if (exemptionService.isExempted(apiKey)) return;

        RateLimitEnforcement r = repo.findByApiKey(apiKey)
                .orElseGet(() -> {
                    RateLimitEnforcement n = new RateLimitEnforcement();
                    n.setApiKey(apiKey);
                    n.setUsedCount(0);
                    n.setDate(LocalDate.now());
                    return n;
                });

        if (!LocalDate.now().equals(r.getDate())) {
            r.setDate(LocalDate.now());
            r.setUsedCount(0);
        }

        if (r.getUsedCount() >= 100)
            throw new RuntimeException("RATE LIMIT EXCEEDED");

        r.setUsedCount(r.getUsedCount() + 1);
        repo.save(r);
    }
}
