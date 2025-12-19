package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.ApiUsageLogService;

@Service
public class ApiUsageLogServiceImpl implements ApiUsageLogService {

    @Override
    public void logUsage(String apiKey) {
        System.out.println("API key used: " + apiKey);
    }
}
