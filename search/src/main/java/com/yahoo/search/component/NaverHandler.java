package com.yahoo.search.component;

import com.yahoo.search.dto.naver.ImageReqDto;
import com.yahoo.search.dto.naver.ImageResDto;
import com.yahoo.search.dto.naver.LocalReqDto;
import com.yahoo.search.dto.naver.LocalResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
public class NaverHandler {

    private final RestTemplate restTemplate;

    @Value("${naver.url.search.local}")
    private String localURI;
    @Value("${naver.url.search.image}")
    private String imageURI;
    @Value("${naver.id}")
    private String id;
    @Value("${naver.secret}")
    private String secret;

    public ImageResDto searchImage(ImageReqDto imageReqDto) {
        var uri = UriComponentsBuilder.fromUriString(imageURI)
                .queryParams(imageReqDto.params())
                .build()
                .encode()
                .toUri();

        var req = RequestEntity.get(uri)
                .header("X-Naver-Client-Id", id)
                .header("X-Naver-Client-Secret", secret)
                .build();

        var res = restTemplate.exchange(req, new ParameterizedTypeReference<ImageResDto>() {
        });

        return res.getBody();
    }

    public LocalResDto searchLocal(LocalReqDto localReqDto) {
        URI uri = UriComponentsBuilder.fromUriString(localURI)
                .queryParams(localReqDto.params())
                .build()
                .encode()
                .toUri();

        var req = RequestEntity.get(uri)
                .header("X-Naver-Client-Id", id)
                .header("X-Naver-Client-Secret", secret)
                .build();

        var res = restTemplate.exchange(req, new ParameterizedTypeReference<LocalResDto>() {
        });

        return res.getBody();
    }
}
