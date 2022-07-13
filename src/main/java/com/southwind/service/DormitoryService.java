package com.southwind.service;

import com.southwind.entity.Dormitory;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-06 15:13
 */
public interface DormitoryService {

    public List<Dormitory> availableList();

    public List<Dormitory> list();

    public List<Dormitory> search(String key,String value);

    public void save(Dormitory dormitory);

    public void update(Dormitory dormitory);

    public void delete(Integer id);

    public List<Dormitory> findByBuildingId(Integer buildingId);
}
