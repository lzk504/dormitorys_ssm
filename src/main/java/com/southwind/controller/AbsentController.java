package com.southwind.controller;


import com.southwind.entity.*;
import com.southwind.service.AbsentService;
import com.southwind.service.BuildingService;
import com.southwind.service.DormitoryService;
import com.southwind.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lzk
 * @create 2022-07-09 14:38
 */
@Controller
@RequestMapping("/absent")
public class AbsentController {

    @Autowired
    private AbsentService absentService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private DormitoryService dormitoryService;

    @GetMapping("list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("absentrecord");
        modelAndView.addObject("list", this.absentService.list());
        return modelAndView;
    }

    @PostMapping("search")
    public ModelAndView search(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("absentrecord");
        modelAndView.addObject("list", this.absentService.search(key, value));
        return modelAndView;
    }
    @GetMapping("/init")
    public ModelAndView init(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("absentregister");
        List<Building> buildingList = this.buildingService.list();
        modelAndView.addObject("buildingList",buildingList);
        List<Dormitory> dormitoryList = this.dormitoryService.findByBuildingId(buildingList.get(0).getId());
        modelAndView.addObject("dormitoryList",dormitoryList);
        List<Student> studentList = this.studentService.findByDormitoryId(dormitoryList.get(0).getId());
        modelAndView.addObject("studentList",studentList);
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(Absent absent, HttpSession session){
//        Date date =new Date();
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//        absent.setCreateDate( simpleDateFormat.format(date));
        DormitoryAdmin dormitoryAdmin = (DormitoryAdmin) session.getAttribute("dormitoryAdmin");
        absent.setDormitoryAdminId(dormitoryAdmin.getId());
        this.absentService.save(absent);
        return "redirect:/absent/list";
    }
}
