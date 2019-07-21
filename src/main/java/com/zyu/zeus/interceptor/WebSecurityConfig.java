package com.zyu.zeus.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.zyu.zeus.define.ReturnCode;
import com.zyu.zeus.helpers.ReturnHelper;
import com.zyu.zeus.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 功能描述
 *
 * @author: zyu
 * @description:
 * @date: 2019/5/30 16:08
 */
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {
    @Autowired
    private ReturnHelper returnHelper;

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

            System.out.println("拦截器  " + request.getRequestURI());
            return true;
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
        //排除配置
//        addInterceptor.excludePathPatterns("/user/getSmsCode", "/user/login","/picture/head/**","/user/fingerprint/login","/user/gesturePassword/login","/user/forcedlogin","/version/update","/error");
        //拦截配置
//        addInterceptor.addPathPatterns("/**");
    }

}
