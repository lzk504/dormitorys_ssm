package com.southwind.mapper;

import com.southwind.entity.Absent;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-09 14:45
 */
public interface AbsentMapper {

    public List<Absent> list();

    public List<Absent> searchByBuildingName(String value);

    public List<Absent> searchByDormitoryName(String value);

    public void save(Absent absent);

}
