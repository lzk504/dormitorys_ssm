package com.southwind.controller;

import com.southwind.entity.DormitoryAdmin;
import com.southwind.service.DormitoryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lzk
 * @create 2022-07-06 9:21
 */
@Controller
@RequestMapping("/dormitoryAdmin")
public class DormitoryAdminController {

    @Autowired
    private DormitoryAdminService dormitoryAdminService;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminmanager");
        modelAndView.addObject("list", this.dormitoryAdminService.list());
        return modelAndView;
    }

    /**
     * 宿管查询
     * @param key
     * @param value
     * @return
     */
    @PostMapping("/search")
    public ModelAndView search(String key, String value){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminmanager");
        modelAndView.addObject("list",this.dormitoryAdminService.search(key,value));
        return modelAndView;
    }

    /**
     * 保存添加宿管，后重定向返回list
     * @param dormitoryAdmin
     * @return
     */
    @PostMapping("/save")
    public String save(DormitoryAdmin dormitoryAdmin){
        this.dormitoryAdminService.save(dormitoryAdmin);
        return "redirect:/dormitoryAdmin/list";
    }

    /**
     * 删除宿管，后重定向返回list
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public String delete(Integer id){
        this.dormitoryAdminService.deleteById(id);
        return "redirect:/dormitoryAdmin/list";
    }

    /**
     * 修改宿管
     * @param dormitoryAdmin
     * @return
     */
    @PostMapping("/update")
    public String update(DormitoryAdmin dormitoryAdmin){
        this.dormitoryAdminService.update(dormitoryAdmin);
        return "redirect:/dormitoryAdmin/list";
    }
}
