package com.yahoo.search.controller;

import com.yahoo.search.dto.ResDto;
import com.yahoo.search.dto.naver.ResultDto;
import com.yahoo.search.service.SearchEngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(path = "/search")
@RestController
public class SearchController {

    private final SearchEngineService engineService;

    @GetMapping(path = "")
    public ResDto search(@RequestParam(name = "query") String query) {
        return engineService.naverSearch(query.trim());
    }

    @PostMapping(path = "/add")
    public ResDto add(@RequestBody ResultDto resultDto){
        return engineService.add(resultDto);
    }

    @GetMapping(path = "/all")
    public ResDto all(){
        return engineService.all();
    }
}
