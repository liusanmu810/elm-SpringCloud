package com.elm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.elm.po.CommonResult;
import com.elm.po.User;
import com.elm.service.UserService;


@RestController
@RequestMapping("/UserController")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUserByIdByPass/{userId}/{password}")
    public CommonResult<User> getUserByIdByPass(@PathVariable("userId") String userId, @PathVariable("password") String password) throws Exception {
        User param = new User();
        param.setUserId(userId);
        param.setPassword(password);
        User user = userService.getUserByIdByPass(param);
        return new CommonResult(200, "success", user);
    }

    @GetMapping("/getUserById/{userId}")
    public CommonResult<Integer> getUserById(@PathVariable("userId") String userId) throws Exception {
        int result = userService.getUserById(userId);
        return new CommonResult(200, "success", result);
    }

    @PostMapping("/saveUser/{userId}/{password}/{userName}/{userSex}")
    public CommonResult<Integer> saveUser(@PathVariable("userId") String userId, @PathVariable("password") String password, @PathVariable("userName") String userName, @PathVariable("userSex") Integer userSex) throws Exception {
        User param = new User();
        param.setUserId(userId);
        param.setPassword(password);
        param.setUserName(userName);
        param.setUserSex(userSex);
        int result = userService.saveUser(param);
        return new CommonResult(200, "success", result);
    }
}