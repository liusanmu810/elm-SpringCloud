package com.elm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elm.mapper.UserMapper;
import com.elm.po.User;
import com.elm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByIdByPass(User user) {
        return userMapper.getUserByIdByPass(user);
    }

    @Override
    public int getUserById(String userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }
}