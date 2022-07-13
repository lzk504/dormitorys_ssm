package com.southwind.mapper;

import com.southwind.entity.Building;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-07 8:25
 */
public interface BuildingMapper {
    public List<Building> list();

    public List<Building> searchByName(String name);

    public List<Building> searchByIntroduction(String introduction);

    public void save(Building building);

    public void update(Building building);

    public void deleteById(Integer id);

}
