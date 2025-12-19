package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ApiUsageLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String apiKey;
    private LocalDateTime accessedAt;

    public Long getId() { return id; }
    public String getApiKey() { return apiKey; }
    public LocalDateTime getAccessedAt() { return accessedAt; }

    public void setApiKey(String apiKey) { this.apiKey = apiKey; }
    public void setAccessedAt(LocalDateTime accessedAt) { this.accessedAt = accessedAt; }
}
