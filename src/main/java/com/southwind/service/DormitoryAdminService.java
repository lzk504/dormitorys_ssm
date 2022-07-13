package com.southwind.service;

import com.southwind.entity.DormitoryAdmin;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-06 9:38
 */
public interface DormitoryAdminService {

    public List<DormitoryAdmin> list();

    public List<DormitoryAdmin> search(String key,String value);

    public void save(DormitoryAdmin dormitoryAdmin);

    public void deleteById(Integer id);

    public void update(DormitoryAdmin dormitoryAdmin);
}
