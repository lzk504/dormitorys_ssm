package com.southwind.controller;

import com.southwind.entity.Student;
import com.southwind.service.DormitoryService;
import com.southwind.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author lzk
 * @create 2022-07-06 13:06
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private DormitoryService dormitoryService;

    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentmanager");
        modelAndView.addObject("list",this.studentService.list());
        modelAndView.addObject("dormitoryList",this.dormitoryService.availableList());
        return modelAndView;
    }

    /**
     * 学生查询
     * @param key
     * @param value
     * @return
     */
    @PostMapping("/search")
    public ModelAndView search(String key,String value){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentmanager");
        modelAndView.addObject("list",this.studentService.search(key,value));
        return modelAndView;
    }

    /**
     * 保存学生
     * @param student
     * @return
     */
    @PostMapping("/save")
    public String save(Student student){
        this.studentService.save(student);
        return "redirect:/student/list";
    }

    /**
     * 学生修改
     * @param student
     * @return
     */
    @PostMapping("/update")
    public String update(Student student){
        this.studentService.update(student);
        return "redirect:/student/list";
    }

    /**
     * 删除学生
     * @param student
     * @return
     */
    @PostMapping("/delete")
    public String delete(Student student){
        this.studentService.deleteById(student);
        return "redirect:/student/list";
    }

    @PostMapping("/findByDormitoryId")
    @ResponseBody
    public List<Student> findByDormitoryId(Integer dormitoryId){
        return this.studentService.findByDormitoryId(dormitoryId);
    }
}
