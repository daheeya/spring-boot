package com.yahoo.search.controller;

import com.yahoo.search.dto.ResDto;
import com.yahoo.search.service.SearchEngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(path = "/search")
@RestController
public class SearchController {

    private final SearchEngineService engineService;

    @GetMapping(path = "")
    public ResDto search(@RequestParam(name = "query") String query) {
        return engineService.naverSearch(query.trim());
    }
}
