package com.bellowschool.vo;

import lombok.Getter;

@Getter
public class ScheduleVo {
    private int id;
    private String title;
    private String description;
    private String start;
    private String end;
    private String type;
    private String username;
    private String backgroundColor;
    private String allday;
}
