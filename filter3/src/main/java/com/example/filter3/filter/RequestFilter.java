package com.example.filter3.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class RequestFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(RequestFilter.class);  // import jakarta.suvlet 으로 해야함!!

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("filter start .....");  // test
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;  // 캐스팅 해서 필터링
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String name = httpServletRequest.getParameter("name");  // getParameter 은 String으로 반환한다.
        String pw = httpServletRequest.getParameter("pw");
        String age = httpServletRequest.getParameter("age");

        // parameter를 검증하고 필요에 의해 추가적인 데이터를 보내거나 할 때
        // attribute를 활용하세요.
        httpServletRequest.setAttribute("updateParam", "kim");  // parameter 추가 request에 속성추가

        // controller 진입전
        filterChain.doFilter(httpServletRequest,httpServletResponse);

        // 디버깅을 해보면 진입전과 후 사이에 로직을 넣어줄 수 있다.

        // controllelr 진입후
        log.info("filter end .....");
    }
}
