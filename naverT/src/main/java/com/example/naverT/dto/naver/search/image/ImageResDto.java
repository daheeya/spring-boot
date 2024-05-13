package com.example.naverT.dto.naver.search.image;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageResDto {
    private Response res;

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private Channel channel;

        @Builder
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Channel{
            private Item item;

            @Builder
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Item{
                private String link;
            }
        }
    }
}
