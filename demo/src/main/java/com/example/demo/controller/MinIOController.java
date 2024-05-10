package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MinIOService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/minio")

public class MinIOController {
    private final MinIOService minIOService;

    public MinIOController(MinIOService minIOService) {
        this.minIOService = minIOService;
    }

    @GetMapping("/")
    public List<String> getAllImageUrls() {
        try {
            return minIOService.getAllImageUrls();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    
}
