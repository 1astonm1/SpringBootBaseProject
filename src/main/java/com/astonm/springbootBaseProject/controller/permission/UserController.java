package com.astonm.springbootBaseProject.controller.permission;

import com.astonm.springbootBaseProject.common.response.ResponseData;
import com.astonm.springbootBaseProject.dao.pojo.dto.permission.SysUserQueryDTO;
import com.astonm.springbootBaseProject.dao.pojo.vo.permission.SysUserListVO;
import com.astonm.springbootBaseProject.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Astonm
 * @Date 2021/12/25
 * @Description:
 **/
@Api(tags = "用户管理模块")
@Slf4j
@RestController
@RequestMapping("/base/permission/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户列表接口", httpMethod = "POST")
    @PostMapping("/list")
    public ResponseData list(@RequestBody SysUserQueryDTO dto) {
        List<SysUserListVO> res = userService.list(dto);
        return ResponseData.success().setData(res);
    }
}
