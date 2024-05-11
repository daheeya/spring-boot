package com.example.naverT.dto.naver.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class FindMeDto {
    private String resultcode;
    private String message;
    private Response response;

    @NoArgsConstructor
    @Data
    @Builder
    @AllArgsConstructor
    public static class Response{
        // 우리가 받아올 정보만 매핑시키면 됨! (우리는 이메일이랑 닉네임만 받아오니까!)
        private String nickname;
        private String email;
    }

}
