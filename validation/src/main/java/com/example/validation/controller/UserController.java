package com.example.validation.controller;


import com.example.validation.dto.ErrorDto;
import com.example.validation.dto.RestDto;
import jakarta.validation.Valid;
import org.apache.coyote.http2.HpackDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/apis")
@RestController
public class UserController {
    /*
    @PostMapping(path = "/post")
    public RestDto post(@RequestBody RestDto restDto){
        return restDto;
    }*/

    /*
    @PostMapping(path = "/info")
    public ResponseEntity<RestDto> restPost(@RequestBody RestDto restDto){
        return ResponseEntity.ok(restDto);
    }
    */


    // 위 코드 validate 적용 @Valid 추가
    /*
    @PostMapping(path = "/info")
    public ResponseEntity<RestDto> restPost(@Valid @RequestBody RestDto restDto){
        return ResponseEntity.ok(restDto);
    }
    */

    // 오류 감지를 위한 web container 의 BindingResult 추가
    // BindingResult를 통해 오류를 잡을 수 있다.
    /*
    @PostMapping(path = "/post/info")
    public ResponseEntity<?> restPost(@Valid @RequestBody RestDto restDto,  // return 타입이 string 이라서 ! <?> 로 바꿔주기
                                            BindingResult bindingResult){

        StringBuilder stringBuilder = new StringBuilder();

        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(e-> {
                String fieldName = (((FieldError)e).getField()); // objectError을 FieldError로 타입 캐스팅
                String msg = ((FieldError)e).getDefaultMessage();
                stringBuilder.append("field: "+fieldName);
                stringBuilder.append("error msg: "+msg+"\n");
                System.out.println(msg);
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(stringBuilder.toString());
        }
        System.out.println("test");
        return ResponseEntity.ok(restDto);
    }
    */

    // 에러 빌드 패턴 적용
    @PostMapping(path = "/post/info")
    public ResponseEntity<?> restPost(@Valid @RequestBody RestDto restDto,  // 런타임 때 정해지므로 ! <?> 로 바꿔주기
                                      BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            ErrorDto errorDto=ErrorDto.builder()
                            .response(HttpStatus.BAD_REQUEST.toString()).build();

            bindingResult.getAllErrors().forEach(e->{ // Stream 이라 forEach 가능
                String fieldName=((FieldError)e).getField();
                String msg=e.getDefaultMessage();
                ErrorDto.AgeError ageError = ErrorDto.AgeError.builder()
                        .field(fieldName)
                        .msg(msg)
                        .build();
                errorDto.addErorr(ageError);  // errors가 아닌 addArray로 해결
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        }
        return ResponseEntity.ok(restDto);
    }
}
