package com.astonm.springbootBaseProject.dao.pojo.vo.permission;

import lombok.Data;

/**
 * @Author Astonm
 * @Date 2021/12/25
 * @Description:
 **/
@Data
public class SysUserListVO {

    private Integer id;

    private String username;

    private Integer sex;

    private String sexStr;

    private Integer status;
}
