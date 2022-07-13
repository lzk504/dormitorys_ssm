package com.southwind.service;

import com.southwind.entity.Moveout;
import com.southwind.entity.Student;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-06 13:07
 */
public interface StudentService {
    public List<Student> list();

    public List<Student> search(String key, String value);

    public void save(Student student);

    public void update(Student student);

    public void deleteById(Student student);

    public List<Student> moveoutList();

    public List<Student> SearchMoveoutList(String key, String value);

    public void moveout(Moveout moveout);

    public List<Student> findByDormitoryId(Integer dormitoryId);


}
