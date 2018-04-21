package com.cs544.roommate.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(value = {"/","/home","/index"})
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
