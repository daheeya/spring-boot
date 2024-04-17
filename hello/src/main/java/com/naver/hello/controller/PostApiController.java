package com.naver.hello.controller;

import com.naver.hello.dto.BodyDto;
import com.naver.hello.dto.HobbyDto;
import com.naver.hello.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(path ="/apis")
@RestController
public class PostApiController {
    // post 방식이기에 @PostMapping
    @PostMapping(path = "/post")
    public void post(@RequestBody Map<String, String> requestData) {
        //post방식은 msg body에 데이터가 넘어오므로
        //@RequestBody 어노테이션을 기억해야 합니다.
        requestData.entrySet().forEach(e -> {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        });
    }

    //Q1.
    // 위에 코드를 dto 객체를 만들어서
    // 클라이언트로 dto 객체를 리턴하는 api를 만들어서 test
    @PostMapping(path="/post/body")
    public BodyDto body(@RequestBody BodyDto bodyDto){

        return bodyDto;
    }

    //Q2.
    // POST http://localhost:8081/apis/post/obj/{1}/param?nick=david

    //data:
    //name, age를 받는다.
    @PostMapping(path="/post/obj/{idx}/param")
    public String postObj(@PathVariable(name="idx")int idx,
                          @RequestParam(name="nick") String nick,
                          @RequestBody String name) {

        return name;
    }

    @PostMapping(path="/post/obj/dto/{idx}/param")
    public UserDto userObj(@PathVariable(name="idx")int idx,
                           @RequestParam(name="nick")String nick,
                           @RequestBody UserDto userDto){
        userDto.setNick(nick);
        userDto.setIdx(idx);
        return userDto;
    }

    @PostMapping(path ="/post/hobby")
    public HobbyDto jsonObj(@RequestBody HobbyDto hobbyDto){

        return hobbyDto;
    }
}

