package com.example.demo.controller;

import com.example.demo.entity.KeyExemption;
import com.example.demo.service.KeyExemptionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exemption")
public class KeyExemptionController {

    private final KeyExemptionService service;

    public KeyExemptionController(KeyExemptionService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public KeyExemption add(@RequestParam String apiKey) {
        return service.addExemption(apiKey);
    }

    @DeleteMapping("/remove/{apiKey}")
    public void remove(@PathVariable String apiKey) {
        service.removeExemption(apiKey);
    }
}
