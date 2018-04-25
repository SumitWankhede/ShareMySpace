package com.cs544.roommate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;

import com.cs544.roommate.domain.Address;
import com.cs544.roommate.domain.Property;
import com.cs544.roommate.domain.Room;
import com.cs544.roommate.domain.User;
import com.cs544.roommate.service.IPropertyService;

@Controller
@RequestMapping("property")
public class PropertyController {
	
	private IPropertyService propertyService;
	
	@Autowired
	public void setPropertyService(IPropertyService roomService) {
		this.propertyService = roomService;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String property(Model model) {
		model.addAttribute("property", new Property());
		model.addAttribute("room", new Room());
		model.addAttribute("address", new Address());
		return "/property/create";
	}

	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model, @ModelAttribute("user") User user) {
		model.addAttribute("properties", propertyService.getPropertyList());
		return "propertyList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProperty(@ModelAttribute("property") Property property) {
		propertyService.addProperty(property);
		return "redirect:/property/";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String findProperty(@PathVariable("id") int id, Model model) {
		Property property = propertyService.getProperty(id);
		model.addAttribute(property);
		return "/property/create";
		//return propertyService.getProperty(id);
	}
	
	
	
//	@GetMapping(value = "/{ownerid}/list")
//	public @ResponseBody List<Property> findPropertyByOwnerId(@PathVariable("ownerid") int ownerId) {
//		return propertyService.getPropertyByOwnerId(ownerId);
//	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateProperty(@RequestBody Property property) {
		propertyService.updateProperty(property);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public String deleteItem(@PathVariable("id") Integer id) {
		propertyService.removeProperty(id);
		return "redirect:/property";
	}
	
//	@PostMapping(value="/create")
//	public String 
	
//	@ModelAttribute("propertyTypes")
//	public List<Property.PropertyType> propertyTypes(){
//		return Arrays.asList(Property.PropertyType.values());
//	}
}
