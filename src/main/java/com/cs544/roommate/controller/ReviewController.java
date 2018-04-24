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
		model.addAttribute("property",new Property());
		//model.addAttribute("user");
		return "review/create2";
	}

	@RequestMapping(value = "review/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("reviews", reviewService.findAll());
		return "review/list2";
	}

	@RequestMapping(value = "review/reviewList", method = RequestMethod.GET)
	public String reviewList(Model model, @RequestParam(value="propertyId") String propertyId) {
		
		List<Review> reviews = reviewService.getReviewByPropertyId(new Integer(propertyId));
		for(Review review : reviews) {
			System.out.println("Review : " + review.getReviewText());
			System.out.println("property details" + review.getProperty().getTitle());
		}
		
		model.addAttribute("reviews", reviews);
		return "review/list2";
	}

	@RequestMapping(value = "review/create", method = RequestMethod.GET)
	private String get(Model model, @ModelAttribute("review") Review review,
			@ModelAttribute("property") Property property,
			@ModelAttribute("user") User user, @RequestParam(value = "propertyId", required = false) Integer propertyId,
			@RequestParam(value = "reviewId") Long reviewId,
			@RequestParam(value = "userId", required = false) Integer userId, BindingResult result) {
		if (reviewId != null && reviewId > 0) { //for update
			Review updatedReview = reviewService.getReview(reviewId);
			System.out.println("Here in get review if ");
			model.addAttribute("review", updatedReview);
			model.addAttribute("property", updatedReview.getProperty());
		} else {
			System.out.println("Here in get review else ");
			review.setProperty(propertyService.getProperty(propertyId));
			review.setUser(userService.findById(1));
			System.out.println("In GET");
		}

		return "/review/create";
	}

	@RequestMapping(value = "review/create", method = RequestMethod.POST)
	private String create(Model model, @ModelAttribute("review") Review review,
			//@ModelAttribute("property") Property property, @ModelAttribute("user") User user,
			@RequestParam(value = "reviewId", required = false) Integer reviewId,
			@RequestParam(value = "propertyId", required = false) Integer propertyId,
			@RequestParam(value = "userId", required = false) Integer userId) {
		
		System.out.println("Here in post review");
//		Property p = propertyService.getProperty(2);
//		review.setProperty(p);
//		review.setUser(userService.findById(1));
		//review.setProperty(property);
		//review.setUser(user);
	
		review.setProperty(propertyService.getProperty(1));
		review.setUser(userService.findById(1));
		reviewService.saveReview(review);
		model.addAttribute("reviews",reviewService.findAll());
		return "redirect:/review/list";
		
	}
	
	@RequestMapping(value = "review/delete/{reviewId}", method = RequestMethod.POST)
	public String delete(@PathVariable("reviewId") int reviewId) {
		Review review = reviewService.getReview(reviewId);
		reviewService.deleteReview(review);
		return "redirect:/review/list";
	}

}
