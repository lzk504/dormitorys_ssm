package com.southwind.mapper;

import com.southwind.entity.Moveout;
import com.southwind.service.TestParent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-09 12:56
 */
public class MoveoutMapperTest extends TestParent {

    @Autowired
    private MoveoutMapper moveoutMapper;

    @Test
    public void list() {
        List<Moveout> list = moveoutMapper.list();
        for (Moveout moveout:list) {
            System.out.println(moveout);
        }
    }

    @Test
    public void searchByStudentName() {
        List<Moveout> list = moveoutMapper.searchByStudentName("米");
        for (Moveout moveout:list) {
            System.out.println(moveout);
        }
    }

    @Test
    public void searchByDormitoryName() {
        List<Moveout> list = moveoutMapper.searchByDormitoryName("101");
        for (Moveout moveout:list) {
            System.out.println(moveout);
        }
    }
}