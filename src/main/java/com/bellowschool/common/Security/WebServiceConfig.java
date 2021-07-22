package com.bellowschool.common.Security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class WebServiceConfig implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(loginInterceptor) //핸들러를 지정
                .addPathPatterns("/**") //인터셉트할 기본 패턴을 지정
                .excludePathPatterns("/vendor/**", "/js/**", "/signup", "/", "/css/**", "/qrcheck", "/scss/**", "/img/**"); // 제외할 패턴들
    }
}
