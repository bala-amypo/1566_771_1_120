package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class KeyExemption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String apiKey;

    public Long getId() { return id; }
    public String getApiKey() { return apiKey; }

    public void setApiKey(String apiKey) { this.apiKey = apiKey; }
}
