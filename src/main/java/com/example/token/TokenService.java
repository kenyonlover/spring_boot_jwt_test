package com.example.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    public String getToken(User user) {
        // 过期时间，5分钟
        long EXPIRE_TIME = 5*60*1000;
        // 生成过期时间
        Date expireDate = new Date(System.currentTimeMillis()+EXPIRE_TIME);

        String token = JWT.create().withAudience(user.getId())// 将 user id 保存到 token 里面
                .withExpiresAt(expireDate)// 设置过期时间
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
