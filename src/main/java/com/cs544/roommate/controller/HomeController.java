package com.cs544.roommate.controller;


import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cs544.roommate.domain.User;

@Controller
public class HomeController {
	
    @RequestMapping(value = {"/","/home","/index"}, method = RequestMethod.GET)
    public ModelAndView home(){
    	//getList() will give us list of properties as by default
    	LinkedList<String> propertyList = getPropertyList();
    	ModelAndView mv = new ModelAndView("index");
        mv.addObject("propertyList", propertyList);
        
        return mv;
    }
    
    @GetMapping("/signup")
	public String signupPage(Model model) {
		//model.addAttribute("person", new User());
		return "signup";
	}
    
    // Implementation to fetch list of properties 
    private LinkedList<String> getPropertyList(){
        LinkedList<String> properties = new LinkedList<String>();
        
        // Fetch the list of properties
        properties.add("Item 1");
        properties.add("Item 2");
        properties.add("Item 3");

        return properties;
    }
}