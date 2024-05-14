package com.yahoo.search.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SearchEngineServiceTest {

    @Autowired
    SearchEngineService service;

    @Test
    void naverSearch() {
        System.out.println(service.naverSearch("커피"));
    }
}