package com.bellowschool.vo;

import lombok.Getter;

@Getter
public class ScheduleVo {
    int id;
    String title;
    String description;
    String start;
    String end;
    String type;
    String username;
    String backgroundColor;
    String allday;
}
