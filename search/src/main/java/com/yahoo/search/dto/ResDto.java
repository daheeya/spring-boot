package com.yahoo.search.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResDto<T> {

    private Header header;
    private T body;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Header {
        private String code;
    }
}
