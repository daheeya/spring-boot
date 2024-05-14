package com.example.naverT.component;

import com.example.naverT.dto.GenericDto;
import com.example.naverT.dto.naver.search.image.ImageReqDto;
import com.example.naverT.dto.naver.search.image.ImageResDto;
import com.example.naverT.dto.naver.search.location.LocalReqDto;
import com.example.naverT.dto.naver.search.location.LocalResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@Slf4j
public class NaverHandler {

    @Value("${naver.uri.search.local}")  // lombok 의 Value가 아닌 Spring의 Value를 import
    private String localUrl;
    @Value("${naver.uri.search.image}")
    private String imageUrl;
    @Value("${naver.id}")
    private String id;
    @Value("${naver.secret}")
    private String secret;


    private final RestTemplate restTemplate;

    public ImageResDto naverSearchImage(ImageReqDto reqDto){

        var makeUri = UriComponentsBuilder.fromUriString(imageUrl)
                .queryParams(reqDto.localParamsMap())
                .encode()
                .build()
                .toUri();

        log.info("image search uri = {}", makeUri);

        var headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", id);
        headers.add("X-Naver-Client-Secret", secret);

        var reqEntity = RequestEntity.get(makeUri)
                .headers(headers)
                .build();

        var resEntity = restTemplate.exchange(reqEntity, ImageResDto.class);
        //var resEntity = restTemplate.execute(reqEntity, new ParameterizedTypeReference<ImageResDto>(){});

        log.info("naver res data = {}", reqDto);

        int length = Integer.parseInt(resEntity.getHeaders().get("Content-Length").get(0));
        var msg = "RES_OK";
        if (length <= 0) msg = "RES_FAIL";

        var res = GenericDto.<ImageResDto>builder()
                .header(GenericDto.Header.builder()
                        .code(resEntity.getStatusCode().toString())
                        .msg(msg).build()
                )
                .body(resEntity.getBody())
                .build();
        return resEntity.getBody();
    }

    public LocalResDto naverLocalSearch(LocalReqDto reqDto) {

        var makeUri = UriComponentsBuilder.fromUriString(localUrl)
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

        var resEntity = restTemplate.exchange(reqEntity, LocalResDto.class);  // 서버에서 NaverResDto 타입으로 반환하니까!

        log.info("naver res data = {}", reqDto);

        int length = Integer.parseInt(resEntity.getHeaders().get("Content-Length").get(0));
        var msg = "RES_OK";
        if (length <= 0) msg = "RES_FAIL";

        return resEntity.getBody();
    }

}
