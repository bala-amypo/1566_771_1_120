package com.example.demo.controller;

import com.example.demo.service.KeyExemptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exemptions")
public class KeyExemptionController {

    private final KeyExemptionService service;

    public KeyExemptionController(KeyExemptionService service) {
        this.service = service;
    }

    @PostMapping("/{apiKey}")
    public ResponseEntity<String> add(@PathVariable String apiKey) {
        service.addExemption(apiKey);
        return ResponseEntity.ok("Exemption added");
    }

    @DeleteMapping("/{apiKey}")
    public ResponseEntity<String> remove(@PathVariable String apiKey) {
        service.removeExemption(apiKey);
        return ResponseEntity.ok("Exemption removed");
    }
}
