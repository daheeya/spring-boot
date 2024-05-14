package com.example.naverT.service.naver.search;

import com.example.naverT.dto.GenericDto;
import com.example.naverT.dto.naver.search.image.ImageReqDto;
import com.example.naverT.dto.naver.search.image.ImageResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RequiredArgsConstructor
@Service
public class SearchImageService {

    @Value("${naver.uri.search.local}")  // lombok 의 Value가 아닌 Spring의 Value를 import
    private String localUrl;
    @Value("${naver.uri.search.image}")
    private String imageUrl;
    @Value("${naver.id}")
    private String id;
    @Value("${naver.secret}")
    private String secret;


    private final RestTemplate restTemplate;

    public GenericDto naverSearchImage(ImageReqDto reqDto){

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
    return res;
    }
}
