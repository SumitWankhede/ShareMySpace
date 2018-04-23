package com.cs544.roommate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs544.roommate.domain.Property;
import com.cs544.roommate.domain.Review;
import com.cs544.roommate.domain.User;
import com.cs544.roommate.repository.ReviewRepository;

@Service
public class ReviewService implements IReviewService{

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Transactional
	public void saveReview(Review review) {
		reviewRepository.save(review);
	}
	
	@Transactional
	public void deleteReview(long reviewId) {
		reviewRepository.deleteById(reviewId);
	}

	@Transactional
	public List<Review> getReviewByProperty(Property property) {
		return reviewRepository.getReviewByProperty(property);
	}

	@Transactional
	public List<Review> getReviewByUser(User user) {
		return reviewRepository.getReviewByUser(user);
	}

	@Transactional
	public List<Review> getAllReview(User user) {
		return reviewRepository.findAll();
	}

}
