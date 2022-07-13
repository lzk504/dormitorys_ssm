package com.southwind.controller;

import com.southwind.entity.Moveout;
import com.southwind.service.MoveoutService;
import com.southwind.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/**
 * @author lzk
 * @create 2022-07-08 11:04
 */
@Controller
@RequestMapping("/moveout")
public class moveoutController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private MoveoutService moveoutService;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutregister");
        modelAndView.addObject("list", this.studentService.moveoutList());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutregister");
        modelAndView.addObject("list", this.studentService.SearchMoveoutList(key, value));
        return modelAndView;
    }

    @PostMapping("/register")
    public String register(Moveout moveout) {
        this.studentService.moveout(moveout);
        return "redirect:/moveout/list";
    }



    @GetMapping("/record")
    public ModelAndView record() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutrecord");
        modelAndView.addObject("list", this.moveoutService.list());
        return modelAndView;
    }
    @PostMapping("/recordSearch")
    public ModelAndView recordSearch(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutrecord");
        modelAndView.addObject("list", this.moveoutService.recordSearch(key, value));
        return modelAndView;
    }
}
