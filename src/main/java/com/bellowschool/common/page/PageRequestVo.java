package com.bellowschool.common.page;

import lombok.Data;

@Data
public class PageRequestVo {
    private int page;
    private int size;
    private int totalcount;

    public PageRequestVo(){
        this.page = 1;
        this.size = 10;
    }
}