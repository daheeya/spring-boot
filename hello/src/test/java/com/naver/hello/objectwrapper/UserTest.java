package com.naver.hello.objectwrapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;  // jackson 씨의 라이브러리
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserTest {

    @Test
    void mapperTest() throws JsonProcessingException {
        var user = new User.Builder().name("kim")
                .age(19)
                .build();  // 각각의 메서드가 Builder 본인을 리턴하기 때문에 이렇게 계속해서 접근이 가능하다. // 이 build 패턴 spring에서 많이 쓰인다.(자동으로 작성해주는 라이브러리도 있움)
        var objWrapper = new ObjectMapper();
        var jsonText = objWrapper.writeValueAsString(user); // JsonProcessingException

        System.out.println(jsonText);

        // Json to Object
        var objVal = objWrapper.readValue(jsonText, User.class);
        System.out.println(objVal.getName() +":"+objVal.getAge());
    }
}