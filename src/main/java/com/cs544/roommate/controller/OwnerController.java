package com.cs544.roommate.controller;

import com.cs544.roommate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    PropertyService propertyService;

    @RequestMapping(value = {"/"})
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("owner/index");
        mv.addObject("properties",propertyService.getPropertyList());
        return mv;
    }
}
