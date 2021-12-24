package com.astonm.springbootBaseProject.dao;


import com.astonm.springbootBaseProject.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserMapperExt extends UserMapper {

    public List<User> findAllUsers();

}
