package com.astonm.springbootBaseProject.common.response;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PageBean {

    // 当前页码
    private int current;

    // 页大小
    private int size;

    // 总页数
    private long pages;

    // 总条数
    private long total;

    // 开始数量
    private int startNum;

    public PageBean() {}

    public PageBean(int current) {
        this.current = current;
    }

    public PageBean(int current, int size, int pages, long total) {
        this.current = current;
        this.size = size;
        this.pages = pages;
        this.total = total;
    }



}
