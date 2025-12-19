package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String apiKey;

    @ManyToOne
    private UserAccount user;

    public Long getId() { return id; }
    public String getApiKey() { return apiKey; }
    public UserAccount getUser() { return user; }

    public void setApiKey(String apiKey) { this.apiKey = apiKey; }
    public void setUser(UserAccount user) { this.user = user; }
}
