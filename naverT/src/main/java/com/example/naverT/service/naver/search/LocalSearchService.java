package com.example.naverT.service.naver.search;

import com.example.naverT.dto.GenericDto;
import com.example.naverT.dto.naver.search.NaverReqDto;
import com.example.naverT.dto.naver.search.NaverResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocalSearchService {
    @Value("${naver.uri.search.local}")  // lombok 의 Value가 아닌 Spring의 Value를 import
    private String uri;
    @Value("${naver.id}")
    private String id;
    @Value("${naver.secret}")
    private String secret;


    private final RestTemplate restTemplate;

    public GenericDto naverLocalSearch(NaverReqDto reqDto) {

        var makeUri = UriComponentsBuilder.fromUriString(uri)
                .queryParams(reqDto.localParamsMap())
                .encode()
                .build()
                .toUri();
        log.info("local search uri = {}", makeUri);  // 로깅 코드 넣는 습관 들이기

        var headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", id);
        headers.add("X-Naver-Client-Secret", secret);

        var reqEntity = RequestEntity.get(makeUri)
                .headers(headers)
                .build();

        var resEntity = restTemplate.exchange(reqEntity, NaverResDto.class);  // 서버에서 NaverResDto 타입으로 반환하니까!

        log.info("naver res data = {}", reqDto);

        int length = Integer.parseInt(resEntity.getHeaders().get("Content-Length").get(0));
        var msg = "RES_OK";
        if (length <= 0) msg = "RES_FAIL";

        return GenericDto.<NaverResDto>builder()
                .header(GenericDto.Header.builder()
                        .code(resEntity.getStatusCode().toString())
                        .msg(msg).build()
                )
                .data(resEntity.getBody())
                .build();
    }
}
