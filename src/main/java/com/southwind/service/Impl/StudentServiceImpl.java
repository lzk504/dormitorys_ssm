package com.southwind.service.Impl;

import com.southwind.entity.Moveout;
import com.southwind.entity.Student;
import com.southwind.mapper.DormitoryMapper;
import com.southwind.mapper.MoveoutMapper;
import com.southwind.mapper.StudentMapper;
import com.southwind.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lzk
 * @create 2022-07-06 13:07
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private MoveoutMapper moveoutMapper;

    @Override
    public List<Student> list() {
        return this.studentMapper.list();
    }

    /**
     * 学生查询
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public List<Student> search(String key, String value) {
        if (key.equals("")) return this.studentMapper.list();
        List<Student> list = null;
        switch (key) {
            case "number":
                list = this.studentMapper.searchByNumber(value);
                break;
            case "name":
                list = this.studentMapper.searchByName(value);
                break;
        }
        return list;
    }

    /**
     * 保存学生
     *
     * @param student
     */
    @Override
    public void save(Student student) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        student.setCreateDate(simpleDateFormat.format(date));
        try {
            this.studentMapper.save(student);
            this.dormitoryMapper.subAvailable(student.getDormitoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 学生修改
     * @param student
     */
    @Override
    public void update(Student student) {
        try {
            this.studentMapper.update(student);
            if(!student.getDormitoryId().equals(student.getOldDormitoryId())){
                this.dormitoryMapper.subAvailable(student.getDormitoryId());
                this.dormitoryMapper.addAvailable(student.getOldDormitoryId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除学生
     * @param student
     */
    @Override
    public void deleteById(Student student) {
        try {
            this.studentMapper.deleteById(student.getId());
            this.dormitoryMapper.addAvailable(student.getDormitoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 可以被迁出的学生
     * @return
     */
    @Override
    public List<Student> moveoutList() {
        return this.studentMapper.moveoutList();
    }

    /**
     * 搜索可以被迁出的学生
     * @param key
     * @param value
     * @return
     */
    @Override
    public List<Student> SearchMoveoutList(String key,String value) {
        if(key.equals(""))return this.studentMapper.moveoutList();
        List<Student> list =null;
        switch (key){
            case "name":
               list =this.studentMapper.searchMoveoutListByName(value);
                break;
            case "number":
                list=this.studentMapper.searchMoveoutListByNumber(value);
                break;
        }
        return list;
    }

    @Override
    public void moveout(Moveout moveout) {
        try {
//        迁出的宿舍加上可入住值
            this.dormitoryMapper.addAvailable(moveout.getDormitoryId());
            //修改学生状态为迁出
            this.studentMapper.updateStateById(moveout.getStudentId());
            //添加迁出学生信息
            Date date =new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            moveout.setCreateDate(simpleDateFormat.format(date));
            this.moveoutMapper.saveMoveout(moveout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> findByDormitoryId(Integer dormitoryId) {
        return this.studentMapper.findByDormitoryId(dormitoryId);
    }


}
