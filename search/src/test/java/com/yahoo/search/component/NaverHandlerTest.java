package com.yahoo.search.component;

import com.yahoo.search.dto.naver.ImageReqDto;
import com.yahoo.search.dto.naver.LocalReqDto;
import com.yahoo.search.service.SearchEngineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NaverHandlerTest {

    @Autowired
    NaverHandler naverHandler;
    @Autowired
    SearchEngineService service;

    @Test
    void searchImage() {
        var imageDto = ImageReqDto.builder().query("국밥").build();
        System.out.println(naverHandler.searchImage(imageDto));
    }

    @Test
    void searchLocal() {
        var localDto = LocalReqDto.builder().query("국밥").build();
        System.out.println(naverHandler.searchLocal(localDto));
    }

    @Test
    void searchEngine() {
       service.naverSearch("국밥");
    }
}