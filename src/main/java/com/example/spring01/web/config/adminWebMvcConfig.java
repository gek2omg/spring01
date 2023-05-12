package com.example.spring01.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.spring01.common.interceptor.LoginInterceptor;

@Configuration
public class adminWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	// TODO Auto-generated method stub
    	WebMvcConfigurer.super.addInterceptors(registry);
    	registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
    }
        
}
