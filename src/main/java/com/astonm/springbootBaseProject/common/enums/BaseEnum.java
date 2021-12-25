package com.astonm.springbootBaseProject.common.enums;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.List;

public interface BaseEnum {

    /**
     * 获取枚举标识
     *
     * @return
     */
    Integer getCode();

    /**
     * 获取枚举描述
     *
     * @return
     */
    String getName();

    /**
     * 通过枚举类型和code值获取对应的枚举类型
     *
     * @param enumType
     * @param code
     * @param <T>
     * @return
     */
    static <T extends BaseEnum> T valueOf(Class<? extends BaseEnum> enumType, Integer code) {
        if (enumType == null || code == null) {
            return null;
        }
        T[] enumConstants = (T[]) enumType.getEnumConstants();
        if (enumConstants == null) {
            return null;
        }
        for (T enumConstant : enumConstants) {
            int enumCode = enumConstant.getCode();
            if (enumCode == code) {
                return enumConstant;
            }
        }
        return null;
    }

    /**
     * 将enum转换为list
     *
     * @param enumType
     * @param <T>
     * @return
     */
    static <T extends BaseEnum> List<JSONObject> enum2List(Class<? extends BaseEnum> enumType) {
        if (enumType == null) {
            return null;
        }
        T[] enumConstants = (T[]) enumType.getEnumConstants();
        if (enumConstants == null) {
            return null;
        }
        LinkedList<JSONObject> results = new LinkedList<JSONObject>();
        for (T bean : enumConstants) {
            String name = bean.getName();
            Integer code = bean.getCode();
            JSONObject map = new JSONObject();
            map.put("code", code);
            map.put("name", name);
            results.add(map);
        }
        return results;
    }


    static <T extends BaseEnum> String getEnumName(Class<? extends BaseEnum> enumType, Integer code) {
        if (enumType == null || code == null) {
            return null;
        }
        T[] enumConstants = (T[]) enumType.getEnumConstants();
        if (enumConstants == null) {
            return null;
        }
        for (T enumConstant : enumConstants) {
            int enumCode = enumConstant.getCode();
            if (enumCode == code) {
                return enumConstant.getName();
            }
        }
        return null;
    }
}