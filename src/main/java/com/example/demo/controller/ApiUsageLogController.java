package com.example.demo.controller;

import com.example.demo.entity.ApiUsageLog;
import com.example.demo.service.ApiUsageLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usage")
public class ApiUsageLogController {

    private final ApiUsageLogService service;

    public ApiUsageLogController(ApiUsageLogService service) {
        this.service = service;
    }

    @GetMapping("/{apiKey}")
    public List<ApiUsageLog> getLogs(@PathVariable String apiKey) {
        return service.getLogs(apiKey);
    }
}
