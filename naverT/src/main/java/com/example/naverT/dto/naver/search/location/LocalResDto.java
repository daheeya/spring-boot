package com.example.naverT.dto.naver.search.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class LocalResDto {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    @Builder.Default
    private List<Item> items = new ArrayList<>();

    @AllArgsConstructor
    @Data
    @Builder
    @NoArgsConstructor
    public static class Item{
        private String title;
        private String link;
        private String category;
        private String descripsion;
        private String telephone;
        private String address;
        private String roadAddress;
        private int mapx;
        private int mapy;
    }
}
