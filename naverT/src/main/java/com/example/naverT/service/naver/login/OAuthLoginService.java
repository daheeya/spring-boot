package com.example.naverT.service.naver.login;


import com.example.naverT.dto.GenericDto;
import com.example.naverT.dto.naver.login.FindMeDto;
import com.example.naverT.dto.naver.login.LoginParamsDto;
import com.example.naverT.dto.naver.login.NaverTokenDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class OAuthLoginService {  //naver.auth.url 을 만들어주는 API


    @Value("${naver.uri.auth}")
    private String authUrl;
    @Value("${naver.redirect-url}")
    private String redirectUrl;
    @Value("${naver.id}")
    private String clientId;
    @Value("${naver.secret}")
    private String clientSecret;
    @Value("${naver.uri.api}")
    private String api;

    private final RestTemplate restTemplate;

    public String naverAuthUrl(){
        return UriComponentsBuilder.fromUriString(authUrl+"/authorize")
                .queryParam("response_type","code")
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret)
                .queryParam("redirect_uri", redirectUrl)
                .queryParam("state","state string")  // MultiParamMap 도 되긴 하지만 yaml에서 데이터를 가져오기 때문에 가독성을 위해 그냥 requestParam을 사용
                .encode()
                .build().toUri().toString();
    }

    public String requestAccessToken(LoginParamsDto loginParamsDto){  // callback으로 LoginParamDto를 받아오기 때문에
        var uri =  UriComponentsBuilder.fromUriString(authUrl+"/token")
                .queryParam("grant_type","authorization_code")
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret)
                .queryParam("code", loginParamsDto.getCode())
                .queryParam("state",loginParamsDto.getState())
                .encode()
                .build().toUri().toString();


        var requestEntity = RequestEntity.get(uri)
                .build();
        var responseEntity = restTemplate.exchange(requestEntity, NaverTokenDto.class);

        return responseEntity.getBody().getAccessToken();
    }

    public String findMe(String tokenCode){
        var uri =  UriComponentsBuilder.fromUriString(api+"/v1/nid/me")
                .encode()
                .build().toUri().toString();
        var headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+ tokenCode);  // 공백 유의!!!!!!!!
        var reqEntity = RequestEntity.get(uri)
                .headers(headers).build();
        var resEntity = restTemplate.exchange(reqEntity, FindMeDto.class);

        return resEntity.getBody().toString();
    }
}
