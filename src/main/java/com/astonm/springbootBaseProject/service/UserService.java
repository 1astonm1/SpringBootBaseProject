package com.astonm.springbootBaseProject.service;

import com.astonm.springbootBaseProject.dao.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAllUser();

}
