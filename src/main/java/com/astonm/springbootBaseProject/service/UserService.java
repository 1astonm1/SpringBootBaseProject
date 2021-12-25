package com.astonm.springbootBaseProject.service;

import com.astonm.springbootBaseProject.dao.pojo.dto.permission.SysUserQueryDTO;
import com.astonm.springbootBaseProject.dao.pojo.vo.permission.SysUserListVO;

import java.util.List;

public interface UserService {

    List<SysUserListVO> list(SysUserQueryDTO dto);

}
