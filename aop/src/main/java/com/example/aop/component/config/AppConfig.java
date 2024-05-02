<<<<<<< HEAD
package com.example.aop.component.config;

import com.example.aop.aspect.EncodingAop;
import com.example.aop.aspect.LoggingAop;
import com.example.aop.aspect.TimerAop;
import com.example.aop.component.Base64Coder;
import com.example.aop.component.IEcoder;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    /*
    @Bean
    public LoggingAop loggingAop(){
        return new LoggingAop();
    }

    @Bean
    public TimerAop timerAop(){
        return new TimerAop();
    }
*/
    @Bean
    public EncodingAop encodingAop(IEcoder iEcoder){
        return new EncodingAop(iEcoder);
    }
    @Bean
    public IEcoder base64Coder(){return new Base64Coder();}
}
=======
package com.example.aop.component.config;

import com.example.aop.aspect.LoggingAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public LoggingAop loggingAop(){
        return new LoggingAop();
    }
}
>>>>>>> parent of 45ea137 (aop2)
