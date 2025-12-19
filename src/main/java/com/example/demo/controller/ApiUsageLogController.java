package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.ApiUsageLogService;

@RestController
@RequestMapping("/api/usage")
public class ApiUsageLogController {

    private final ApiUsageLogService apiUsageLogService;

    public ApiUsageLogController(ApiUsageLogService apiUsageLogService) {
        this.apiUsageLogService = apiUsageLogService;
    }

    @PostMapping("/{apiKey}")
    public String log(@PathVariable String apiKey) {
        apiUsageLogService.logUsage(apiKey);
        return "Logged";
    }
}
