package com.example.ioc.controller;

import com.example.ioc.component.config.JsonConv;
import com.example.ioc.component.encode.BaseEncoder;
import com.example.ioc.component.encode.Encoder;
import com.example.ioc.dto.MsgConverterDto;
import com.example.ioc.dto.ResDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import jdk.jfr.Frequency;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/apis")
@RestController
public class ApiController {
    private final BaseEncoder baseEncoder;
    private final Encoder encoder;
    private final JsonConv jsonConv;
    public ApiController(BaseEncoder baseEncoder, Encoder encoder, JsonConv jsonConv, Encoder encoder1, JsonConv jsonConv1){
        this.baseEncoder=baseEncoder;
        this.encoder = encoder;
        this.jsonConv = jsonConv;
    }
    @GetMapping(path="/msg")
    public ResponseEntity msgConvert(@RequestParam(name = "url") String msg){
        System.out.println("client msg url = "+msg);
        return ResponseEntity.status(HttpStatus.OK)
                .body(MsgConverterDto
                        .builder()
                        .msg(msg)
                        .build()
                        .getMsg());
    }
    @GetMapping(path="/encode/str")
    public String encodeStr(@RequestParam(name = "msg") String msg){
        return baseEncoder.encode(msg);
    }

    @PostMapping("/person")
    public ResponseEntity<ResDto> personInfo(@RequestBody ResDto resDto) throws JsonProcessingException {
        return ResponseEntity.ok(ResDto.builder()
                .response(HttpStatus.OK.toString())
                .jsonMsg(jsonConv.objTojson(resDto))
                .build());
    }
}

