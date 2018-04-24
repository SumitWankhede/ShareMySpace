package com.cs544.roommate.controller;

import java.util.List;

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

import com.cs544.roommate.domain.Property;
import com.cs544.roommate.domain.Review;
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
		return "review/create";
	}

	@RequestMapping(value = "review/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("reviews", reviewService.findAll());
		return "review/list";
	}

	@RequestMapping(value = "review/reviewList", method = RequestMethod.GET)
	public String reviewList(Model model, @RequestParam(value="propertyId") String propertyId) {
		List<Review> reviews = reviewService.getReviewByPropertyId(new Integer(propertyId));
		model.addAttribute("reviews", reviews);
		return "review/list";
	}

	@RequestMapping(value = "review/create", method = RequestMethod.GET)
	private String get(Model model, @ModelAttribute("review") Review review,
			@RequestParam(value = "propertyId" ,required=false) String propertyId,
			@RequestParam(value = "reviewId" ,required=false) String reviewId,
			@RequestParam(value = "userId" ,required=false) String userId, BindingResult result) {
		return "/review/create";
	}

	@RequestMapping(value = "review/create/{id}", method = RequestMethod.POST)
	private String create(Model model, @ModelAttribute("review") Review review,
			@PathVariable("id") String propertyId, BindingResult result) { 
		propertyService.addReview(propertyId, review);
		model.addAttribute("reviews",reviewService.findAll());
		return "redirect:/review/list";
		
	}
	
	@RequestMapping(value = "review/edit/{reviewId}", method = RequestMethod.GET)
	private String get(Model model, @ModelAttribute("review") Review review,
			@PathVariable("reviewId") String reviewId, BindingResult result) {
		model.addAttribute("review" , reviewService.getReview(Long.parseLong(reviewId)));
		return "/review/create";
	}
	
	@RequestMapping(value = "review/edit/{reviewId}", method = RequestMethod.POST)
	private String edit(Model model, @ModelAttribute("review") Review review,
			@PathVariable("reviewId") String reviewId, BindingResult result) { 
		System.out.println("here");
		reviewService.updateReview(reviewId , review);
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
