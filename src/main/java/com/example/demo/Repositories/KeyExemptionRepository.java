package com.example.demo.repository;

import com.example.demo.entity.KeyExemption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyExemptionRepository
        extends JpaRepository<KeyExemption, Long> {

    boolean existsByApiKey(String apiKey);
    void deleteByApiKey(String apiKey);
}
