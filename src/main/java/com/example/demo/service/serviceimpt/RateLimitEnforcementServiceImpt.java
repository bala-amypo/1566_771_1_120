package com.example.demo.service.impl;

import com.example.demo.entity.ApiQuota;
import com.example.demo.exception.QuotaExceededException;
import com.example.demo.repository.ApiQuotaRepository;
import com.example.demo.service.RateLimiterService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RateLimiterServiceImpl implements RateLimiterService {

    private final ApiQuotaRepository repo;

    public RateLimiterServiceImpl(ApiQuotaRepository repo) {
        this.repo = repo;
    }

    @Override
    public void validateRequest(String apiKey) {
        ApiQuota quota = repo.findByApiKey(apiKey)
                .orElseThrow(() -> new QuotaExceededException("Invalid API Key"));

        if (!LocalDate.now().equals(quota.getQuotaDate())) {
            quota.setQuotaDate(LocalDate.now());
            quota.setUsedCount(0);
        }

        if (quota.getUsedCount() >= quota.getDailyLimit()) {
            throw new QuotaExceededException("Daily quota exceeded");
        }

        quota.setUsedCount(quota.getUsedCount() + 1);
        repo.save(quota);
    }
}
