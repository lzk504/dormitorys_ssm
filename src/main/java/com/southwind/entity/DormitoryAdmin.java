package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lzk
 * @create 2022-07-05 16:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DormitoryAdmin {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String gender;
    private String telephone;
}
