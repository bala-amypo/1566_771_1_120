package com.example.demo.controller;

import com.example.demo.entity.ApiKey;
import com.example.demo.service.ApiKeyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apikey")
public class ApiKeyController {

    private final ApiKeyService service;

    public ApiKeyController(ApiKeyService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ApiKey create(@RequestParam Long userId) {
        return service.createApiKey(userId);
    }

    @GetMapping("/{key}")
    public ApiKey get(@PathVariable String key) {
        return service.getApiKey(key);
    }
}
