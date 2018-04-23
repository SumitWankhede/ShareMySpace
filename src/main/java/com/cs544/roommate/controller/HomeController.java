package com.cs544.roommate.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cs544.roommate.domain.User;

@Controller
public class HomeController {
    @RequestMapping(value = {"/","/home","/index","login"})
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    
    @RequestMapping(value = {"/ratings"})
    public ModelAndView ratings(){
        ModelAndView mv = new ModelAndView("ratings");
        return mv;
    }
    /*
    @GetMapping("/signup")
	public String signupPage(Model model) {
		//model.addAttribute("person", new User());
		return "signup";
	}*/
    
    @RequestMapping(value = {"/rooms"})
    public ModelAndView rooms(){
        ModelAndView mv = new ModelAndView("rooms");
        return mv;
    }
}
