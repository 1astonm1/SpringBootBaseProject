package com.astonm.springbootBaseProject.service.impl;

import com.astonm.springbootBaseProject.dao.UserMapper;
import com.astonm.springbootBaseProject.dao.UserMapperExt;
import com.astonm.springbootBaseProject.pojo.User;
import com.astonm.springbootBaseProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Astonm
 * @Date 2021/7/4
 * @Description:
 **/

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperExt userMapperExt;

    @Override
    public List<User> findAllUser() {
        List<User> allUsers = userMapperExt.findAllUsers();
        return allUsers;
    }
}
