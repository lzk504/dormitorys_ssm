package com.southwind.mapper;

import com.southwind.entity.Dormitory;

import java.sql.Driver;
import java.util.List;

/**
 * @author lzk
 * @create 2022-07-06 15:16
 */
public interface DormitoryMapper {
    public List<Dormitory> availableList();

    public void subAvailable(Integer id);

    public void addAvailable(Integer id);

    public List<Integer> findByBuildingId(Integer buildingId);

    public Integer findAvailableDormitoryId();

    public void delete(Integer id);

    public List<Dormitory> list();

    public List<Dormitory> searchByName(String name);

    public List<Dormitory> searchByTelephone(String telephone);

    public void save(Dormitory dormitory);

    public void update(Dormitory dormitory);

    public List<Dormitory> findByBuildingIdList(Integer buildingId);

}
