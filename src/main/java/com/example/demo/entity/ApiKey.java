package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ApiQuota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String apiKey;

    private int dailyLimit;
    private int usedCount;
    private LocalDate quotaDate;

    public Long getId() { return id; }
    public String getApiKey() { return apiKey; }
    public int getDailyLimit() { return dailyLimit; }
    public int getUsedCount() { return usedCount; }
    public LocalDate getQuotaDate() { return quotaDate; }

    public void setApiKey(String apiKey) { this.apiKey = apiKey; }
    public void setDailyLimit(int dailyLimit) { this.dailyLimit = dailyLimit; }
    public void setUsedCount(int usedCount) { this.usedCount = usedCount; }
    public void setQuotaDate(LocalDate quotaDate) { this.quotaDate = quotaDate; }
}
