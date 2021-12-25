package com.astonm.springbootBaseProject.common.enums;

import lombok.Getter;

/**
 * @author Astonm
 * @date 2021/12/25
 * 用户性别枚举类
 **/
@Getter
public enum UserSexStatusEmus implements BaseEnum {
    /**
     *  男
     */
    MAN(0, "男"),
    /**
     *  女
     */
    WOMAN(1, "女"),
    ;

    private Integer code;
    private String name;

    UserSexStatusEmus(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
