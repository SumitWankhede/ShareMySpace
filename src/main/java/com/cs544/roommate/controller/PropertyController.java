package com.cs544.roommate.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cs544.roommate.domain.Address;
import com.cs544.roommate.domain.Property;
import com.cs544.roommate.domain.Review;
import com.cs544.roommate.domain.Room;
import com.cs544.roommate.service.IPropertyService;

@Controller
public class PropertyController {
	
	private IPropertyService propertyService;
	
	@Autowired
	public void setPropertyService(IPropertyService roomService) {
		this.propertyService = roomService;
	}

	@RequestMapping(value = "/property", method = RequestMethod.GET)
	public String property() {
		//reviewService.saveReview(review);
		return "property";
	}
	
	@RequestMapping(value = "/properties", method = RequestMethod.GET)	
	public String list(Model model) {
		//return propertyService.getPropertyList();	
		model.addAttribute("properties", propertyService.getPropertyList());
		return "propertyList";
	}

	@RequestMapping(value = "/addProperty", method = RequestMethod.POST)
	//@ResponseStatus(HttpStatus.CREATED)
	public String addProperty(@ModelAttribute("property") Property property, @ModelAttribute("room") Room room, @ModelAttribute("address") Address address) {
		property.setRoom(room);
		property.setAddress(address);
		propertyService.addProperty(property);
		return "redirect:/properties";
	}

	@RequestMapping(value = "/property/{id}", method = RequestMethod.GET)
	public @ResponseBody Property findProperty(@PathVariable("id") int id) {
		return propertyService.getProperty(id);
	}

	@RequestMapping(value = "/property", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateProperty(@RequestBody Property property) {
		propertyService.updateProperty(property);
	}

	@RequestMapping(value = "/room/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteItem(@PathVariable("id") Integer id) {
		propertyService.removeProperty(id);
	}
	
}
