package com.cs544.roommate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.cs544.roommate.service.PropertyService;
import com.cs544.roommate.utils.SearchParam;

@Controller
public class HomeController {
	@Autowired
	private PropertyService propertyService;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		((Model) mv).addAttribute("propertyList", propertyService.getPropertyList());

		return mv;
	}

	@RequestMapping(value = { "/ratings" })
	public ModelAndView ratings() {
		ModelAndView mv = new ModelAndView("ratings");
		return mv;
	}

	@RequestMapping(value = { "/details" })
	public ModelAndView details() {
		ModelAndView mv = new ModelAndView("details");
		return mv;
	}

	@RequestMapping(value = { "/rooms" })
	public ModelAndView rooms() {
		ModelAndView mv = new ModelAndView("rooms");
		return mv;
	}

	@PostMapping({ "/search" })
	public String search(Model model, @ModelAttribute("search") SearchParam searchParam) {
		model.addAttribute("propertyList",
				propertyService.search(searchParam.getLocation(), searchParam.getTypeOfRoom(),
						searchParam.getNoOfRooms(), searchParam.getBudgetMin(), searchParam.getBudgetMax()));
		return "index";
	}
}
