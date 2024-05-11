package com.example.naverT.controller;


import com.example.naverT.dto.naver.login.LoginParamsDto;
import com.example.naverT.service.naver.login.OAuthLoginService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@RequestMapping(path = "/oauth")
@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final OAuthLoginService oAuthLoginService;

    @GetMapping("/home")
    public String home(){
        return "/home";
    }

    // html단에서 naver login 버튼 선택 시 적용되는 URI
    @GetMapping("/naver/login")
    public void naverLogin(HttpServletResponse response) throws IOException {
        response.sendRedirect(oAuthLoginService.naverAuthUrl());
    }

    // 콜백이 잘 넘어오는지 작성해보는 코드
    @ResponseBody
    @GetMapping("/naver")
    public ResponseEntity callbackNaver(LoginParamsDto loginParamsDto){
        log.info("code={}, state = {}", loginParamsDto.getCode(), loginParamsDto.getState());
        var token = oAuthLoginService.requestAccessToken(loginParamsDto);  // 디버깅 통해서 토큰 잘 받아오는지 확인하기.

        return ResponseEntity.ok(oAuthLoginService.findMe(token));
    }
}
