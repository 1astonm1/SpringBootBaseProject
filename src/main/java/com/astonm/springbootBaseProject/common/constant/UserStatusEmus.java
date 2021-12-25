package com.astonm.springbootBaseProject.common.constant;

import lombok.Getter;

/**
 * @author Astonm
 * @date 2021/12/25
 * 用户状态 1-正常 2-禁用/删除
 **/
@Getter
public enum UserStatusEmus implements BaseEnum {

    /**
     *  用户正常
     */
    NORMAL(1, "正常"),
    /**
     *  用户删除
     */
    DELETE(2, "禁用/删除"),
    ;

    private Integer code;
    private String name;

    UserStatusEmus(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
