package com.cs544.roommate.controller;

import java.util.List;

import javax.mail.MessagingException;

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

import com.cs544.roommate.config.SessionListener;
import com.cs544.roommate.config.SmtpMailSender;
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
	private SmtpMailSender reviewMailSender;
	@Autowired
	private SessionListener sessionListener;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "review/{propertyId}/{userId}", method = RequestMethod.GET)
	public String createReview(Model model, @PathVariable("propertyId") String propertyId,
			@PathVariable("userId") String userId) {
		model.addAttribute("review", new Review());
		Property property = propertyService.getPropertyById(propertyId);
		User user = userService.getUserById(Long.parseLong(userId));
		System.out.println("Get user id : " + user.getId());
		model.addAttribute("property", property);
		model.addAttribute("user", user);
		return "review/create";
	}

	// Retrieve all reviews
	@RequestMapping(value = "review/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("reviews", reviewService.findAll());
		return "review/list";
	}

	// To ignore first
	@RequestMapping(value = "review/create", method = RequestMethod.GET)
	private String get(Model model, @ModelAttribute("review") Review review,
			@ModelAttribute("property") Property property, @ModelAttribute("user") User user,
			@RequestParam(value = "propertyId", required = false) String propertyId,
			@RequestParam(value = "reviewId", required = false) String reviewId,
			@RequestParam(value = "userId", required = false) String userId, BindingResult result) {

		return "/review/create";
	}

	@RequestMapping(value = "review/create/{propertyId}/{userId}", method = RequestMethod.POST)
	private String create(Model model, @ModelAttribute("review") Review review,
			@RequestParam(value = "id", required = false) Long id, @PathVariable("propertyId") String propertyId,
			@PathVariable("userId") String userId, BindingResult result) {
		System.out.println("id>>>>>" + id);
		if (id != null && id > 0) {
			System.out.println("Call to update" + propertyId);
			propertyService.addReview(propertyId, review);
			userService.addReview(userId, review);
			reviewService.updateReview(id, review);
		} else {
			propertyService.addReview(propertyId, review);
			System.out.println("user Id  :" + userId);
			userService.addReview(userId, review);
		}
		model.addAttribute("reviews", reviewService.getReviewByUserId(Long.valueOf(userId)));
		// return "redirect:/review/list";
		try {
			reviewMailSender.sendMail(sessionListener.getUser().getEmail(), "Added!!!!", "Some text here.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "redirect:/review/reviewsByUser/" + userId;
	}

	@RequestMapping(value = "review/edit/{reviewId}", method = RequestMethod.GET)
	private String get(Model model, @ModelAttribute("review") Review review, @PathVariable("reviewId") int reviewId,
			BindingResult result) {
		System.out.println("id in edit " + reviewId);
		if (reviewId > 0) {
			Review reviewToUpdate = reviewService.getReview(reviewId);
			Property property = reviewToUpdate.getProperty();
			User user = reviewToUpdate.getUser();
			model.addAttribute("review", reviewToUpdate);
			model.addAttribute("property", property);
			model.addAttribute("user", user);
			// model.addAttribute("id",reviewId);
		}

		return "/review/create";
	}

	@RequestMapping(value = "review/edit/{reviewId}", method = RequestMethod.POST)
	private String edit(Model model, @ModelAttribute("review") Review review, @ModelAttribute("user") User user,
			@PathVariable("reviewId") Long reviewId, BindingResult result) {
		System.out.println("here" + user.getId());
		reviewService.updateReview(reviewId, review);
		model.addAttribute("reviews", reviewService.getReviewByUserId(user.getId()));
		return "redirect:/review/list";

	}

	@RequestMapping(value = "review/delete/{reviewId}", method = RequestMethod.POST)
	public String delete(Model model, @PathVariable("reviewId") int reviewId) {
		Review review = reviewService.getReview(reviewId);
		reviewService.deleteReview(review);
		model.addAttribute("reviews", reviewService.getReviewByUserId((review.getUser()).getId()));
		return "/review/list";
	}

	// Retrieve review list by propertyId
	@RequestMapping(value = "review/reviewByProperty/{propertyId}", method = RequestMethod.GET)
	public String reviewListByPropertyId(Model model, @PathVariable(value = "propertyId") String propertyId) {
		List<Review> reviews = reviewService.getReviewByPropertyId(new Integer(propertyId));
		Property property = propertyService.getProperty(new Integer(propertyId));
		model.addAttribute("property ", property);
		model.addAttribute("reviews", reviews);
		return "review/list";
	}

	// Retrieve review list by userId
	@RequestMapping(value = "review/reviewsByUser/{userId}", method = RequestMethod.GET)
	public String reviewListByUserId(Model model, @PathVariable(value = "userId") String userId) {
		List<Review> reviews = reviewService.getReviewByUserId(Long.parseLong(userId));
		model.addAttribute("reviews", reviews);
		return "review/list";
	}
}
