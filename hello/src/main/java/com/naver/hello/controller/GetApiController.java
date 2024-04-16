package com.naver.hello.controller;

import com.naver.hello.dto.UserDto;
import org.springframework.web.bind.annotation.*;

// URI 지정 annotation
// http://localhost:8081/apis
@RequestMapping(path = "/apis")  // RequestMapping 은 GET, POST, DELETE, ... 등 들어오는 요청을 다 수행하겠다는 소리, URL = unique 한 URL 이여야한다.(당연하쥬)
@RestController  // rest 전용 controller (page관련 controller 가 아님)
public class GetApiController {

    // GET http://localhost:8081/apis/hello
    // Http method get method
    @GetMapping(path = "/hello")
    public String hello(){  // public 필수
        return "hello spring boot!";
    }

    // http://localhost:8081/apis/name/{kim}
    // URI path에 있는 변수라고 해서  PathVariable 이라고 말함.
    @GetMapping(path = "/name1/{idx}")
    public String pathVar(@PathVariable(name="idx")String name){

        return "path-variable value = " + name;
    }

    // 해보기
    // GET http://localhost:8080/apis/name/{kim}/age/{18}
    @GetMapping(path = "name/{first}/age/{old}")
    public String age(@PathVariable(name="first")String name,
                      @PathVariable(name="old") int age){
        return "userInfo name: " + name + "age: " + age;
    }

    // require test
    // /name/kim/age/20, /name/park
    @GetMapping(path = {"name/{first}/age/{old}","name/{first}"})
    public String required (@PathVariable(name="first")String name,
                            @PathVariable(name="old", required = false) Integer age){  // required false : 하면 Integer 로 받아야 함
        if(age == null) age = 1;
        return "userInfo name: " + name + "age: " + age;
    }

    /*
     * Query Parameter
     */

    // http://localhost:8080/apis/query?id=kim&pw=1234
    @GetMapping(path = "/query")
    public String queryParams(@RequestParam(name="id")String userId,
                              @RequestParam(name="pw")String password){
        return userId + ":" + password;
    }

    // http://localhost:8080/apis/query2?id=kim&pw=1234&name=park&addr=busan
    @GetMapping(path = "/query2")
    public String queryParams1(@RequestParam(name="id")String userId,
                               @RequestParam(name="pw")String password,
                               @RequestParam(name="addr")String addr){
        return userId + ":" + password +":" + addr;
    }

    // http://localhost:8080/apis/query2/{name}/{age}?id=kim&pw=1234
    @GetMapping(path="/query2/{name}/{age}")
    public String queryParams2(@RequestParam(name = "name")String userName,
                               @RequestParam(name = "age") int age,
                               @RequestParam(name = "id")String id,
                               @RequestParam(name = "pw")String pw){
        return userName +":"+ age +":"+ id +":"+ pw;
    }

    // Map으로 한번에 여러개의 Query param 을 받을 수 있다.
    @GetMapping(path = "/query/map")
    public String queryMap(@RequestParam java.util.Map<String,String> params){
        var sb = new StringBuilder();
        params.entrySet().forEach(e->{  // entrySet() : set 안에 map의 key와 value 를 넣을 수 있다.
            System.out.println("key : " + e.getKey());
            System.out.println("value : " + e.getValue());
            System.out.println();

            String id;
            // 결국 사용자로부터 넘겨진 값을 받아서 처리를 위해서는 조건문을 통해 처리가 이루어지니 동일하다.
            if(e.getKey().equals("id")) id = e.getValue();

            sb.append(e.getKey() + "=" + e.getValue());
        });
        return sb.toString();

    }

    //Object Mapper
    @GetMapping(path = "/obj")
    public UserDto queryParamObj(UserDto userDto){  // dto를 받는다.
        return userDto;
    }

}
