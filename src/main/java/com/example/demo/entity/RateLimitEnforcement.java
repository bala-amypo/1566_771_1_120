package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class RateLimitEnforcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String apiKey;
    private int usedCount;
    private LocalDate date;

    public Long getId() { return id; }
    public String getApiKey() { return apiKey; }
    public int getUsedCount() { return usedCount; }
    public LocalDate getDate() { return date; }

    public void setApiKey(String apiKey) { this.apiKey = apiKey; }
    public void setUsedCount(int usedCount) { this.usedCount = usedCount; }
    public void setDate(LocalDate date) { this.date = date; }
}
