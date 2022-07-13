package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lzk
 * @create 2022-07-05 16:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemAdmin {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String telephone;

}
