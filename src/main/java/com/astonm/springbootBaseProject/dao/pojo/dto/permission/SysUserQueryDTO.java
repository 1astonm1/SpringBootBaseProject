package com.astonm.springbootBaseProject.dao.pojo.dto.permission;

import lombok.Data;

/**
 * @Author Astonm
 * @Date 2021/12/25
 * @Description:
 **/
@Data
public class SysUserQueryDTO {
    private String username;

    private Integer sex;

    private Integer status;
}
