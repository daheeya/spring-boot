package com.example.naverT.dto.naver.search.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class LocalReqDto {
    private String query;
    @Builder.Default
    private int display= 1;
    @Builder.Default
    private int start= 1;
    @Builder.Default
    private String sort= "random";

    public MultiValueMap localParamsMap(){
        var map = new LinkedMultiValueMap<String, String>();  // 어차피 URI에 들어갈 값이기 때문에 <String,String>으로 해주면된다.
        map.add("query",query);
        map.add("display", String.valueOf(start));
        map.add("start", String.valueOf(start));
        map.add("sort",sort);

        return map;
    }
}
