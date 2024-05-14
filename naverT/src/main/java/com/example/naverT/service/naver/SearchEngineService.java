package com.example.naverT.service.naver;

import com.example.naverT.component.NaverHandler;
import com.example.naverT.dto.GenericDto;
import com.example.naverT.dto.naver.ResultDto;
import com.example.naverT.dto.naver.search.image.ImageReqDto;
import com.example.naverT.dto.naver.search.location.LocalReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class SearchEngineService {

    private final NaverHandler naverHandler;

    public GenericDto<ResultDto> naverSearch(String query){
        var localRes = naverHandler.naverLocalSearch(LocalReqDto.builder().query(query).build());
        if(localRes.getTotal()>0){
            var imageRes = naverHandler.naverSearchImage(ImageReqDto.builder().query(localRes.getItems().get(0).getTitle()).build());

            var item = imageRes.getItems().get(0);

            var resultDto = ResultDto.builder().title(localRes.getItems().get(0).getTitle())
                    .image(item.getLink())
                    .category(localRes.getItems().get(0).getCategory())
                    .roadAddress(localRes.getItems().get(0).getRoadAddress())
                    .address(localRes.getItems().get(0).getAddress())
                    .homepage(localRes.getItems().get(0).getLink())
                    .build();
            return GenericDto.<ResultDto>builder()
                    .body(resultDto)
                    .header(GenericDto.Header.builder().code("S_01").build())
                    .build();
        }
        return null;
    }
}
