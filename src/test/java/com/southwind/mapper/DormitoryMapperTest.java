package com.southwind.mapper;

import com.southwind.service.TestParent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-08 8:37
 */
public class DormitoryMapperTest extends TestParent {
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Test
    public void findByBuildingId() {
        List<Integer> list = dormitoryMapper.findByBuildingId(1);
        for (Integer dormitoryId: list) {
            System.out.println(dormitoryId);
        }

    }
}