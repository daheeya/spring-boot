package com.example.naverT.service.naver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SearchEngineServiceTest {

    @Autowired
    SearchEngineService searchEngineService;
    @Test
    void naverSearch() {
        searchEngineService.naverSearch("커피");
    }
}