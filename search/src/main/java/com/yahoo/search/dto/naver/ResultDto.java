package com.yahoo.search.dto.naver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResultDto {
    private String title;
    private String homepage;
    private String category;
    private String address;
    private String roadAddress;
    private String image;
}
