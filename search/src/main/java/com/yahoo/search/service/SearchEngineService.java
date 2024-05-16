package com.yahoo.search.service;

import com.yahoo.search.component.NaverHandler;
import com.yahoo.search.db.SearchRepository;
import com.yahoo.search.dto.ResDto;
import com.yahoo.search.dto.naver.ImageReqDto;
import com.yahoo.search.dto.naver.LocalReqDto;
import com.yahoo.search.dto.naver.ResultDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SearchEngineService {
    private final NaverHandler naverHandler;
    private final SearchRepository searchRepository;

    public ResDto<ResultDto> naverSearch(String query) {
        var localRes = naverHandler.searchLocal(LocalReqDto.builder().query(query).build());
        //log.info("local search = {}", localRes);
        if (localRes.getTotal() > 0) {
            var imageRes = naverHandler.searchImage(ImageReqDto.builder().query(localRes.getItems().get(0).getTitle()).build());
            //log.info("image search = {}", imageRes);
            var item = imageRes.getItems().get(0);
            var resultDto = ResultDto.builder().title(localRes.getItems().get(0).getTitle())
                    .image(item.getLink())
                    .category(localRes.getItems().get(0).getCategory())
                    .roadAddress(localRes.getItems().get(0).getRoadAddress())
                    .address(localRes.getItems().get(0).getAddress())
                    .homepage(localRes.getItems().get(0).getLink())
                    .build();

            return ResDto.<ResultDto>builder()
                    .body(resultDto)
                    .header(ResDto.Header.builder().code("S_01").build())
                    .build();

        }
        return null;
    }

    public ResDto<ResultDto> add(ResultDto resultDto){
        return ResDto.<ResultDto>builder()
                .body(searchRepository.save(resultDto))
                .header(ResDto.Header.builder().code("S_01").build())
                .build();
    }

    public ResDto<List<ResultDto>> all(){
        return ResDto.<List<ResultDto>>builder()
                .body(searchRepository.findAll())
                .header(ResDto.Header.builder().code("S_01").build())
                .build();
    }
}
