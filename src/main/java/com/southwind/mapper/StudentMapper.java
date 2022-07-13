package com.southwind.mapper;

import com.southwind.entity.Moveout;
import com.southwind.entity.Student;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-06 12:53
 */
public interface StudentMapper {
    public List<Student> list();

    public List<Student> searchByNumber(String value);

    public List<Student> searchByName(String value);

    public void save(Student student);

    public void update(Student student);

    public void deleteById(Integer id);

    public List<Integer> findStudentIdByDormitoryId(Integer dormitoryId);

    public void resetDormitoryId(Integer StudentId, Integer DormitoryId);

    public List<Student> moveoutList();

    public List<Student> searchMoveoutListByNumber(String value);

    public List<Student> searchMoveoutListByName(String value);

    public void updateStateById(Integer id);

    public List<Student> findByDormitoryId(Integer dormitoryId);

}

