package com.example.demo.controller;

import com.example.demo.service.RateLimitEnforcementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratelimit")
public class RateLimitEnforcementController {

    private final RateLimitEnforcementService service;

    public RateLimitEnforcementController(RateLimitEnforcementService service) {
        this.service = service;
    }

    @GetMapping("/check")
    public String check(@RequestHeader("X-API-KEY") String apiKey) {
        service.validate(apiKey);
        return "ALLOWED";
    }
}
