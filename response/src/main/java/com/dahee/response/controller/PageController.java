package com.dahee.response.controller;

import com.dahee.response.dto.ObjDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/page")
// html page를 return 하는 controller
@Controller
public class PageController {

    // GET /page/user/{age}?name=kim
    @ResponseBody  // API 개수가 얼마 안될 땐 계속 레스트컨트롤러 매핑하기 번거로우니까 이렇게 사용하는게 결코 잘못된 게 아니당 가독성과 관리측면에서는 분리하는게 맞지만 필요에 따라서는 이렇게 묶어서 두어도 된다.
    @GetMapping(path = "/user/{age}")
    public ObjDto user(@PathVariable (name = "age")int age,
                       @RequestParam (name = "name")String name){

        var objDto = new ObjDto();
        objDto.setAge(age);
        objDto.setName(name);
        return objDto;
    }

    @GetMapping(path = "/hello")
    public String hello(){
        return "/hello";
    }

}
