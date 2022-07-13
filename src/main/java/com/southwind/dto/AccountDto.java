package com.southwind.dto;

import com.southwind.entity.SystemAdmin;
import lombok.Data;

/**
 * @author lzk
 * @create 2022-07-05 17:17
 */
@Data
public class AccountDto<T> {
    /**
     * -1表示用户名错误
     * -2表示密码错误
     * 0表示登录成功
     */
    private Integer code;
    private T admin;
}
