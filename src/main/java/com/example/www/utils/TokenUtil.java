package com.example.www.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class TokenUtil {
    public static String getToken(String userId,String sign){
        return JWT.create().withAudience(userId) //把 user ID保存到token里面作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(),2)) // 2小时后token过期
                .sign(Algorithm.HMAC256(sign)); // 以password为token的密钥
    }
}
