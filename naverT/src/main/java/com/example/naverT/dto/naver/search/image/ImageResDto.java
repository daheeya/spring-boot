package com.example.naverT.dto.naver.search.image;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageResDto {
    private int total;

    @Builder.Default
    private List<Item> items = new ArrayList<>();

    @AllArgsConstructor
    @Data
    @Builder
    @NoArgsConstructor
    public static class Item{
        private String title;
        private String link;
    }
}
