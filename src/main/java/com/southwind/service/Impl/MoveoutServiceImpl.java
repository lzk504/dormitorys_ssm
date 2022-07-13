package com.southwind.service.Impl;

import com.southwind.entity.Moveout;
import com.southwind.mapper.MoveoutMapper;
import com.southwind.service.MoveoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-09 13:04
 */
@Service
public class MoveoutServiceImpl implements MoveoutService {

    @Autowired
    private MoveoutMapper moveoutMapper;

    @Override
    public List<Moveout> list() {
        return this.moveoutMapper.list();
    }

    @Override
    public List<Moveout> recordSearch(String key, String value) {
        if(key.equals(""))return moveoutMapper.list();
        List<Moveout> list =null;
        switch (key){
            case "studentName":
                list=this.moveoutMapper.searchByStudentName(value);
                break;
            case "dormitoryName":
                list=this.moveoutMapper.searchByDormitoryName(value);
                break;
        }
        return list;
    }

}
