package com.yahoo.search.db;

import com.yahoo.search.dto.naver.ResultDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SearchRepositoryTest {
    @Autowired
    SearchRepository searchRepository;

    @Test
    void dummyDBTest() {

        searchRepository.save(ResultDto.builder()
                .title("할매국수")
                .category("한식")
                .address("제주도 서귀포시")
                .build());
        searchRepository.save(ResultDto.builder()
                .title("자매국수")
                .category("한식")
                .address("제주도 구료동 자매거리")
                .build());
        searchRepository.findAll().forEach(System.out::println);

    }
}