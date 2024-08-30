package com.example.www.config;

import com.example.www.Common.Interceptor.AdminJWTInterceptor;
import com.example.www.Common.Interceptor.UserJWTInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 加自定义拦截器JwtInterceptor，设置拦截规则
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/admin/**")//拦截所有请求，通过 token 是否合法来决定是否需要登录
                .excludePathPatterns("/login/admin");//无需验证的网址
        registry.addInterceptor(userJWTInterceptor())
                .addPathPatterns("/client/**")
                .excludePathPatterns("/client/hotel/show","/client/area/show","/client/area/rand");
    }
    @Bean
    public AdminJWTInterceptor jwtInterceptor(){
        return new AdminJWTInterceptor();
    }
    @Bean
    public UserJWTInterceptor userJWTInterceptor(){
        return new UserJWTInterceptor();
    }

}
