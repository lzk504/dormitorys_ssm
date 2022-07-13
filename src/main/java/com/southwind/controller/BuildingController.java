package com.southwind.controller;

import com.southwind.entity.Building;
import com.southwind.entity.Student;
import com.southwind.service.BuildingService;
import com.southwind.service.DormitoryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lzk
 * @create 2022-07-07 8:18
 */
@Controller
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;
    @Autowired
    private DormitoryAdminService dormitoryAdminService;


    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("buildingmanager");
        modelAndView.addObject("list", this.buildingService.list());
        modelAndView.addObject("dormitoryAdminList", this.dormitoryAdminService.list());
        return modelAndView;
    }

    /**
     *楼宇搜索
     * @return
     */
    @PostMapping("/search")
    public ModelAndView search(String key,String value){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("buildingmanager");
        modelAndView.addObject("list",this.buildingService.search(key,value));
        return modelAndView;
    }

    /**
     * 保存新楼宇信息
     * @param building
     * @return
     */
    @PostMapping("/save")
    public String save(Building building){
        this.buildingService.save(building);
        return "redirect:/building/list";
    }

    /**
     * 修改楼宇信息
     * @param building
     * @return
     */
    @PostMapping("/update")
    public String update(Building building){
        this.buildingService.update(building);
        return "redirect:/building/list";
    }

    /**
     * 删除楼宇信息
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public String delete(Integer id){
        this.buildingService.deleteById(id);
        return "redirect:/building/list";
    }
}
