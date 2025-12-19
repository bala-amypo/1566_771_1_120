package com.example.demo.service.impl;

import com.example.demo.entity.ApiKey;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.ApiKeyService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApiKeyServiceImpl implements ApiKeyService {

    private final ApiKeyRepository apiKeyRepository;
    private final UserAccountRepository userAccountRepository;

    public ApiKeyServiceImpl(ApiKeyRepository apiKeyRepository,
                             UserAccountRepository userAccountRepository) {
        this.apiKeyRepository = apiKeyRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public ApiKey createApiKey(Long userId) {
        UserAccount user = userAccountRepository.findById(userId).orElseThrow();

        ApiKey key = new ApiKey();
        key.setApiKey(UUID.randomUUID().toString());
        key.setUser(user);

        return apiKeyRepository.save(key);
    }

    @Override
    public ApiKey getApiKey(String apiKey) {
        return apiKeyRepository.findByApiKey(apiKey).orElseThrow();
    }
}
