package com.astonm.springbootBaseProject.controller;

import com.astonm.springbootBaseProject.pojo.User;
import com.astonm.springbootBaseProject.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Astonm
 * @Date 2021/7/4
 * @Description:
 **/
@RestController
@RequestMapping("/user")
@Api(tags = "用户操作模块")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/findAllUsers")
    @ApiOperation(value = "获取所有用户信息", httpMethod = "GET")
    public List<User> findAllUsers(){
        List<User> allUser = userService.findAllUser();
        return allUser;
    }

}
