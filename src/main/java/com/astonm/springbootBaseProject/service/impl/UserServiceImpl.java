package com.astonm.springbootBaseProject.service.impl;

import com.astonm.springbootBaseProject.common.enums.BaseEnum;
import com.astonm.springbootBaseProject.common.enums.UserSexStatusEmus;
import com.astonm.springbootBaseProject.common.enums.UserStatusEmus;
import com.astonm.springbootBaseProject.common.utils.CheckUtils;
import com.astonm.springbootBaseProject.dao.entity.SysUser;
import com.astonm.springbootBaseProject.dao.mapper.permission.SysUserMapper;
import com.astonm.springbootBaseProject.dao.pojo.dto.permission.SysUserQueryDTO;
import com.astonm.springbootBaseProject.dao.pojo.vo.permission.SysUserListVO;
import com.astonm.springbootBaseProject.dao.service.permission.SysUserService;
import com.astonm.springbootBaseProject.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Astonm
 * @Date 2021/7/4
 * @Description:
 **/

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public List<SysUserListVO> list(SysUserQueryDTO dto) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        if (!CheckUtils.isBlankOrNull(dto.getUsername())) {
            queryWrapper.eq(SysUser::getUsername, dto.getUsername());
        }
        if (!CheckUtils.isBlankOrNull(dto.getSex())) {
            queryWrapper.eq(SysUser::getSex, dto.getSex());
        }
        queryWrapper.eq(SysUser::getStatus, UserStatusEmus.NORMAL.getCode());
        List<SysUser> sysUsers = sysUserMapper.selectList(queryWrapper);
        List<SysUserListVO> result = new ArrayList<>();
        for (SysUser sysUser : sysUsers) {
            SysUserListVO vo = new SysUserListVO();
            vo.setId(sysUser.getId());
            vo.setUsername(sysUser.getUsername());
            vo.setSex(sysUser.getSex());
            vo.setSexStr(BaseEnum.getEnumName(UserSexStatusEmus.class, sysUser.getSex()));
            vo.setStatus(sysUser.getStatus());
            result.add(vo);
        }
        return result;
    }
}
