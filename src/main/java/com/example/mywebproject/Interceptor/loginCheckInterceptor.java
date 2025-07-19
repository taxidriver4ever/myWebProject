package com.example.mywebproject.Interceptor;

import com.example.mywebproject.Dao.loginRedis;
import com.example.mywebproject.Pojo.myResult;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Component
public class loginCheckInterceptor implements HandlerInterceptor {

    private final Log log = LogFactory.getLog(loginCheckInterceptor.class);

    @Autowired
    private loginRedis loginredis;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        String userId = request.getHeader("userId");
        if(userId == null || authorization == null) { return false; }
        String isLoggedIn = loginredis.getIsLoggedIn(userId);
        log.info("isLoggedIn: " + isLoggedIn);
        log.info("authorization: " + authorization);
        log.info("userId: " + userId);
        if (authorization.equals(isLoggedIn))
            return true;
        else {
            response.getWriter().write("login-fail");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
