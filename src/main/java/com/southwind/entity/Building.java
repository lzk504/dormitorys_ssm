package com.southwind.entity;

import lombok.Data;

/**
 * @author lzk
 * @create 2022-07-07 8:16
 */
@Data
public class Building {
    private Integer id;
    private String name;
    private String introduction;
    private Integer adminId;
    private String adminName;
}
