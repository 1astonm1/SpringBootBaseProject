package com.astonm.springbootBaseProject.dao.mapper;


import com.astonm.springbootBaseProject.dao.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserMapperExt extends UserMapper {

    public List<User> findAllUsers();

}
