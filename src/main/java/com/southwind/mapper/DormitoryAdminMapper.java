package com.southwind.mapper;

import com.southwind.entity.Dormitory;
import com.southwind.entity.DormitoryAdmin;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-06 9:26
 */
public interface DormitoryAdminMapper {

    public List<DormitoryAdmin> list();

    public List<DormitoryAdmin> searchByUsername(String value);

    public List<DormitoryAdmin> searchByName(String value);

    public List<DormitoryAdmin> searchByTelephone(String value);

    public void save(DormitoryAdmin dormitoryAdmin);

    public void deleteById(Integer id);

    public void update(DormitoryAdmin dormitoryAdmin);

    public DormitoryAdmin findByUsername(String username);
}
