package com.example.mywebproject.Config;

import com.example.mywebproject.Interceptor.loginCheckInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class loginCheckInConfig implements WebMvcConfigurer {

    private static final Logger log = LoggerFactory.getLogger(loginCheckInConfig.class);
    @Autowired
    private loginCheckInterceptor logincheckinterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logincheckinterceptor)
                .excludePathPatterns("/login")
                .excludePathPatterns("/register")
                .excludePathPatterns("/sendCode")
                .excludePathPatterns("/sendCode2")
                .excludePathPatterns("/loginByEmail");
    }
}
