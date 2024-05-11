package com.example.naverT.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class GenericDto<T> {
    private Header header;
    private T data;

    @AllArgsConstructor
    @Data
    @Builder
    @NoArgsConstructor
    public static class Header{
        private String code;
        private String msg;
    }
}
