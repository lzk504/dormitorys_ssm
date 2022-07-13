package com.southwind.service.Impl;

import com.southwind.entity.Building;
import com.southwind.mapper.BuildingMapper;
import com.southwind.mapper.DormitoryMapper;
import com.southwind.mapper.StudentMapper;
import com.southwind.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-07 8:29
 */
@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingMapper buildingMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public List<Building> list() {
        return this.buildingMapper.list();
    }

    /**
     * 搜索楼宇信息
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public List<Building> search(String key, String value) {
        if (key.equals("")) return this.buildingMapper.list();
        List<Building> list = null;
        switch (key) {
            case "name":
                list = this.buildingMapper.searchByName(value);
                break;
            case "introduction":
                list = this.buildingMapper.searchByIntroduction(value);
                break;
        }
        return list;
    }

    /**
     * 保存楼宇信息
     *
     * @param building
     */
    @Override
    public void save(Building building) {
        try {
            this.buildingMapper.save(building);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改楼宇信息
     *
     * @param building
     */
    @Override
    public void update(Building building) {
        try {
            this.buildingMapper.update(building);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除楼宇信息
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        try {
            //获取宿舍楼名
            List<Integer> dormitoryIdList = this.dormitoryMapper.findByBuildingId(id);
            //找到楼宇包含的所有宿舍
            for (Integer  dormitoryId : dormitoryIdList) {
                //找到宿舍包含的所有学生
                List<Integer> studentIdList = this.studentMapper.findStudentIdByDormitoryId(dormitoryId);
                for (Integer studentId: studentIdList) {
                    //学生调换宿舍
                    Integer availableDormitoryId = this.dormitoryMapper.findAvailableDormitoryId();
                    this.studentMapper.resetDormitoryId(studentId,availableDormitoryId);
                    this.dormitoryMapper.subAvailable(availableDormitoryId);
                }
                //删除宿舍，删除楼宇
                this.dormitoryMapper.delete(dormitoryId);
            }
            this.buildingMapper.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
