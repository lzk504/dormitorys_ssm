package com.southwind.entity;

import lombok.Data;

/**
 * @author lzk
 * @create 2022-07-09 14:42
 */
@Data
public class Absent {
    private Integer id;
    private Integer buildingId;
    private String buildingName;
    private Integer dormitoryId;
    private String dormitoryName;
    private Integer studentId;
    private String studentName;
    private Integer dormitoryAdminId;
    private String dormitoryAdminName;
    private String createDate;
    private String reason;
}
