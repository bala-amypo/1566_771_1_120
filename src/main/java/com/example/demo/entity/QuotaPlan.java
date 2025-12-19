package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class QuotaPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int dailyLimit;

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getDailyLimit() { return dailyLimit; }

    public void setName(String name) { this.name = name; }
    public void setDailyLimit(int dailyLimit) { this.dailyLimit = dailyLimit; }
}
