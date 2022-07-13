package com.southwind.service.Impl;

import com.southwind.entity.DormitoryAdmin;
import com.southwind.mapper.DormitoryAdminMapper;
import com.southwind.service.DormitoryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-06 9:38
 */
@Service
public class DormitoryAdminServiceImpl implements DormitoryAdminService {
    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;

    @Override
    public List<DormitoryAdmin> list() {
        return this.dormitoryAdminMapper.list();
    }

    /**
     * 宿管查询
     * @param key
     * @param value
     * @return
     */
    @Override
    public List<DormitoryAdmin> search(String key, String value) {
        if (key.equals("")) return this.dormitoryAdminMapper.list();
        List<DormitoryAdmin> list = null;
        switch (key){
            case "username":
                list=dormitoryAdminMapper.searchByUsername(value);
                break;
            case "name":
                list=dormitoryAdminMapper.searchByName(value);
                break;
            case "telephone":
                list=dormitoryAdminMapper.searchByTelephone(value);
                break;
        }
        return list ;
    }

    /**
     * 添加宿管
     * @param dormitoryAdmin
     */
    @Override
    public void save(DormitoryAdmin dormitoryAdmin) {
        try {
            this.dormitoryAdminMapper.save(dormitoryAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除宿管
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        try {
            this.dormitoryAdminMapper.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改宿管
     * @param dormitoryAdmin
     */
    @Override
    public void update(DormitoryAdmin dormitoryAdmin) {
        try {
            this.dormitoryAdminMapper.update(dormitoryAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
