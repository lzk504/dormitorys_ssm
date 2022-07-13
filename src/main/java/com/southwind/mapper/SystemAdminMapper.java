package com.southwind.mapper;

import com.southwind.entity.SystemAdmin;

/**
 * @author lzk
 * @create 2022-07-05 17:24
 */
public interface SystemAdminMapper {
        public SystemAdmin findByUsername(String username);
}
