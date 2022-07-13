package com.southwind.service;

import com.southwind.entity.Moveout;
import com.southwind.entity.Student;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-06 13:07
 */
public interface MoveoutService {
    public List<Moveout> list();

    public List<Moveout> recordSearch(String key, String value);

}
