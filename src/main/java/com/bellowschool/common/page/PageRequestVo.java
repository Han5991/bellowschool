package com.bellowschool.common.page;

import lombok.Data;

@Data
public class PageRequestVo {

    private int page;

    private int size;

    private String type;

    private String keyword;

    private String status;
    public PageRequestVo() {
        this.page = 1;
        this.size = 10;
    }
}
