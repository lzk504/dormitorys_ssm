package com.southwind.service;

import com.southwind.entity.Building;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-07 8:28
 */
public interface BuildingService {
    public List<Building> list();

    public List<Building> search(String key,String value);

    public void save(Building building);

    public void update(Building building);

    public void deleteById(Integer id);
}
