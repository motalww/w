package com.example.www.Common.Interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.www.Pojo.Admin;
import com.example.www.Service.UserService;
import com.example.www.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
public class AdminJWTInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token=request.getHeader("token");
        //如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        //执行认证
        if (StrUtil.isBlank(token)){
            throw new ServiceException(0,"无token，请重新登录");
        }
        //获取 token 中的 adminId
        String adminId;
        try {
            adminId= JWT.decode(token).getAudience().get(0);
        }catch (JWTDecodeException j){
            throw new ServiceException(0,"token验证失败，请重新登录");
        }
        //使用 token 中的 adminID 查询数据库
        Admin admin=userService.getById(adminId);
        if(admin==null){
            throw new ServiceException(0,"用户不存在，请重新登录");
        }
        //密码加签证验证token
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(admin.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        }catch (JWTVerificationException e){
                throw new ServiceException(0,"token验证失败,请重新登录");
        }
        return true;
    }
}
