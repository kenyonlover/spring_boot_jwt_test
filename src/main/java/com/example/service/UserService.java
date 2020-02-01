package com.example.service;

import com.example.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findUserById(String userId) {
        User user = new User();
        user.setId("1");
        user.setUsername("zhangsan");
        user.setPassword("zhangsan");
        return user;
    }
}
