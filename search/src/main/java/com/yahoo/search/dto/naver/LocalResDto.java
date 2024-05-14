package com.yahoo.search.dto.naver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LocalResDto {

    private int total;

    @Builder.Default
    List<Item> items = new ArrayList<>();

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Item {
        private String title;
        private String link;
        private String category;
        private String address;
        private String roadAddress;
    }
}
