package com.dahee.response.controller;

import com.dahee.response.dto.ObjDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/apis")
@RestController
public class ClientController {

    @GetMapping(path = "/text")
    public String account(@RequestParam(name = "account")String account){
        System.out.println("account param="+account);

        return "account = " + account;
    }

    @PostMapping(path = "/obj")
    public ObjDto obj(@RequestBody ObjDto objDto){
        System.out.println(objDto);
        return objDto;
    }

    // ResponseEntity : Http Status값 제어
    @GetMapping(path = "entity")
    public ResponseEntity testEntity(){

        var objDto = new ObjDto();
        objDto.setName("dahee");
        objDto.setAge(23);
        return ResponseEntity.status(HttpStatus.CREATED).body(objDto);
        //return ResponseEntity.ok(objDto);
    }
}
