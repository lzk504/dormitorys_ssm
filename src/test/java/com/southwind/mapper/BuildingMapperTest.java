package com.southwind.mapper;

import com.southwind.entity.Building;
import com.southwind.service.TestParent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


/**
 * @author lzk
 * @create 2022-07-07 15:50
 */
public class BuildingMapperTest extends TestParent {
    @Autowired
    private BuildingMapper buildingMapper;
    @Test
    public void testList() {
        List<Building> list = buildingMapper.list();
        for (Building building: list) {
            System.out.println(building);
        }
    }
}