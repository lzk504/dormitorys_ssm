package com.southwind.service;

import com.southwind.entity.Absent;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-09 15:00
 */
public interface AbsentService {
    public List<Absent> list();

    public List<Absent> search(String key,String value);

    public void save(Absent absent);

}
