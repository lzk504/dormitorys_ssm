package com.southwind.entity;

import lombok.Data;

/**
 * @author lzk
 * @create 2022-07-09 10:16
 */
@Data
public class Moveout {
    private Integer id;
    private Integer studentId;
    private String studentName;
    private Integer dormitoryId;
    private String dormitoryName;
    private String reason;
    private String createDate;
}
