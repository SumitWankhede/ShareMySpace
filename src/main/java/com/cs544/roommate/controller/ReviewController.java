package com.cs544.roommate.controller;

import java.lang.invoke.MethodType;
import java.net.Authenticator.RequestorType;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cs544.roommate.domain.Review;
import com.cs544.roommate.service.ReviewServiceImpl;

@Controller
public class ReviewController {

	@Autowired
	private ReviewServiceImpl reviewService;

	/*@RequestMapping(value = "/add/1", method = RequestMethod.POST)
	public String addReview(@PathVariable(value = "review") Review review) {
		reviewService.saveReview(review);
		return "redirect:/index";
	}*/
	
	@RequestMapping(value = "/reviewform", method = RequestMethod.GET)
	public String review() {
		//reviewService.saveReview(review);
		return "reviewform";
	}
	
	@RequestMapping(value = "/addReview", method = RequestMethod.GET)
	public String addReview(@ModelAttribute("reviw") Review review) {
		return "addReview";
		
	}
	
	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
	public String add(@Valid Review review, BindingResult result) {
		reviewService.saveReview(review);
		return "redirect:/reviews";
	}

	@RequestMapping(value = "/reviews")
	public String reviewList(Model model) {
		model.addAttribute("reviews", reviewService.getAllReview(null));
		return "reviewList";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String deleteReview(@PathVariable(value = "id") String id) {
		reviewService.deleteReview(Long.parseLong(id));
		return "redirect:/";
	}
}
