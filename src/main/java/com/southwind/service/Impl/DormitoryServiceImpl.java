package com.southwind.service.Impl;

import com.southwind.entity.Dormitory;
import com.southwind.mapper.DormitoryMapper;
import com.southwind.mapper.StudentMapper;
import com.southwind.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-06 15:15
 */
@Service
public class DormitoryServiceImpl implements DormitoryService {
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 有空余床位的宿舍
     *
     * @return
     */
    @Override
    public List<Dormitory> availableList() {
        return this.dormitoryMapper.availableList();
    }

    @Override
    public List<Dormitory> list() {
        return this.dormitoryMapper.list();
    }

    /**
     * 搜索宿舍
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public List<Dormitory> search(String key, String value) {
        if (key.equals("")) return this.dormitoryMapper.list();
        List<Dormitory> list = null;
        switch (key) {
            case "name":
                list = this.dormitoryMapper.searchByName(value);
                break;
            case "telephone":
                list = this.dormitoryMapper.searchByTelephone(value);
                break;
        }
        return list;
    }

    /**
     * 保存宿舍信息
     */
    @Override
    public void save(Dormitory dormitory) {
        try {
            this.dormitoryMapper.save(dormitory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改宿舍
     */
    @Override
    public void update(Dormitory dormitory) {
        try {
            this.dormitoryMapper.update(dormitory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除宿舍
     */
    @Override
    public void delete(Integer id) {
        try {
            List<Integer> studentIdList = this.studentMapper.findStudentIdByDormitoryId(id);
            for(Integer studentId:studentIdList){
                Integer availableDormitoryId = this.dormitoryMapper.findAvailableDormitoryId();
                this.studentMapper.resetDormitoryId(studentId,availableDormitoryId);
                this.dormitoryMapper.subAvailable(availableDormitoryId);
            }
            this.dormitoryMapper.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Dormitory> findByBuildingId(Integer buildingId) {
        return this.dormitoryMapper.findByBuildingIdList(buildingId);
    }

}
