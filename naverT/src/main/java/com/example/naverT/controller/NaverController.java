package com.example.naverT.controller;

import com.example.naverT.dto.naver.search.NaverReqDto;
import com.example.naverT.service.naver.search.LocalSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@RequestMapping(path = "/naver/apis")
@RequiredArgsConstructor
public class NaverController {

    private final LocalSearchService localSearchService;

    @GetMapping("/local/search")
    public ResponseEntity localSearch(NaverReqDto reqDto){
        log.info("Naver Controller local Search Data = {}", reqDto);
        return ResponseEntity.ok(localSearchService.naverLocalSearch(reqDto));
    }
}
