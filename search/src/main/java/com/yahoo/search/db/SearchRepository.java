package com.yahoo.search.db;

import com.yahoo.search.dto.naver.ResultDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class SearchRepository {

    private List<ResultDto> db = new ArrayList<>();
    private Long idx = 1L;

    public ResultDto findById(Long idx){
        return null;
    }

    public ResultDto save(ResultDto dto){
        dto.setIdx(idx++);
        db.add(dto);
        return dto;
    }

    public List<ResultDto> findAll(){
        return db;
    }


}
