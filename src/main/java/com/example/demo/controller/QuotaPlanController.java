package com.example.demo.controller;

import com.example.demo.entity.QuotaPlan;
import com.example.demo.service.QuotaPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quota")
public class QuotaPlanController {

    private final QuotaPlanService service;

    public QuotaPlanController(QuotaPlanService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public QuotaPlan create(@RequestBody QuotaPlan plan) {
        return service.create(plan);
    }

    @GetMapping("/all")
    public List<QuotaPlan> getAll() {
        return service.getAll();
    }
}
