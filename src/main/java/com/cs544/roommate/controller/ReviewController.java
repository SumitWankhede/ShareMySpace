package com.cs544.roommate.controller;

import java.lang.invoke.MethodType;
import java.net.Authenticator.RequestorType;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cs544.roommate.domain.Property;
import com.cs544.roommate.domain.Review;
import com.cs544.roommate.domain.Review2;
import com.cs544.roommate.domain.User;
import com.cs544.roommate.service.PropertyService;
import com.cs544.roommate.service.ReviewService;
import com.cs544.roommate.service.UserService;

@Controller

public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private PropertyService propertyService;

	@Autowired
	private UserService userService;

	@GetMapping("/review")
	public String createReview(Model model) {
		model.addAttribute("review", new Review());
		return "review/create2";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("review", reviewService.findAll());
		return "review/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	private String get(Model model, @ModelAttribute("review") Review2 review, Integer userId, BindingResult result) {
		System.out.println("Coming");
		model.addAttribute("review", new Review2());
		return "/review/create";
	}
	/*
	 * @RequestMapping(value = "/create", method = RequestMethod.GET) private String
	 * get(Model model, @ModelAttribute("review") Review
	 * review, @ModelAttribute("property") Property property,
	 * 
	 * @ModelAttribute("user") User user, @RequestParam(value = "propertyId",
	 * required = false) Integer propertyId,
	 * 
	 * @RequestParam(value = "reviewId") Long reviewId,
	 * 
	 * @RequestParam(value = "userId", required = false) Integer userId,
	 * BindingResult result) { if (reviewId != null && reviewId > 0) { Review
	 * updatedReview = reviewService.getReview(reviewId);
	 * model.addAttribute("review",updatedReview);
	 * model.addAttribute("property",updatedReview.getUser()); } else {
	 * review.setProperty(propertyService.getProperty(propertyId));
	 * review.setUser(userService.findById(1)); System.out.println("In GET"); }
	 * 
	 * return "/review/create"; }
	 */
	/*
	 * @RequestMapping(value = "/create", method = RequestMethod.POST) private
	 * String create(Model model, @ModelAttribute("review") Review review,
	 * 
	 * @ModelAttribute("property") Property property, @ModelAttribute("user") User
	 * user,
	 * 
	 * @RequestParam(value = "id", required = false) Integer id,
	 * 
	 * @RequestParam(value = "userId", required = false) Integer userId) {
	 * 
	 * Property p = propertyService.getProperty(2); review.setProperty(p);
	 * review.setUser(userService.findById(1)); reviewService.saveReview(review);
	 * return "redirect:/review/reviewsList"; }
	 * 
	 */

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable("id") int id) {
		Review review = reviewService.getReview(id);
		reviewService.deleteReview(review);
		return "redirect:/review";
	}

}
