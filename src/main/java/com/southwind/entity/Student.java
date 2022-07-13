package com.southwind.entity;

import lombok.Data;

/**
 * @author lzk
 * @create 2022-07-06 12:42
 */
@Data
public class Student {
    private Integer id;
    private String number;
    private String name;
    private String gender;
    private Integer dormitoryId;
    private Integer oldDormitoryId;
    private String dormitoryName;
    private String state;
    private String createDate;
}
