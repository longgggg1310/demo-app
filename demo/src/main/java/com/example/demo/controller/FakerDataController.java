package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.service.FakerDataService;

@RestController
@RequestMapping("/api/faker_data")

public class FakerDataController {
    private final FakerDataService fakerDataService;

    public FakerDataController(FakerDataService fakerDataService) {
        this.fakerDataService = fakerDataService;
    }

    @PostMapping("/{count}")
    public String generateFakeDataList(@PathVariable int count) {
        return fakerDataService.generateFakeDataList(count);
    }
}
