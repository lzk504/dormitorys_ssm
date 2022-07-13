package com.southwind.entity;

import lombok.Data;

/**
 * @author lzk
 * @create 2022-07-06 15:07
 */
@Data
public class Dormitory {
    private Integer id;
    private Integer buildingId;
    private String buildingName;
    private String name;
    private Integer type;
    private Integer available;
    private String telephone;
}
