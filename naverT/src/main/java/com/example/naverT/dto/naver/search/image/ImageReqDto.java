package com.example.naverT.dto.naver.search.image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageReqDto {
    private String query;
    @Builder.Default
    private int display=10;
    @Builder.Default
    private int start=1;
    @Builder.Default
    private String sort="sim";
    @Builder.Default
    private String filter="all";


    // 어제 배운 내용
    public MultiValueMap localParamsMap(){ // service의 uri 에 쓰인다.
        var map = new LinkedMultiValueMap<String, String>();  // 어차피 URI에 들어갈 값이기 때문에 <String,String>으로 해주면된다.
        map.add("query",query);
        map.add("display", String.valueOf(start));
        map.add("start", String.valueOf(start));
        map.add("sort",sort);
        map.add("filter",filter);

        return map;
    }
}
