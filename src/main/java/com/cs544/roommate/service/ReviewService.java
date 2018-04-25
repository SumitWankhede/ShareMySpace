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
public class ReviewService implements IReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Transactional
	public void createReview(String reviewId, String propertyId, Review review) {
		
		reviewRepository.save(review);
	}

	@Transactional
	public void deleteReview(Review review) {
		reviewRepository.delete(review);
	}

	public Review getReview(long id) {
		return reviewRepository.findOne(id);
	}

	@Transactional
	public List<Review> getReviewByProperty(Property property) {
		return reviewRepository.getReviewByProperty(property);
	}
	
	@Transactional
	public List<Review> getReviewByPropertyId(int propertyId) {
		System.out.println(propertyId);
		return reviewRepository.getReviewByPropertyId(propertyId);
	}
	
	@Transactional
	public List<Review> getReviewByUserId(Long userId) {
		System.out.println(userId);
		return reviewRepository.getReviewByUserId(userId);
	}

	public void updateReview(Long reviewId , Review review){
		Review toUpdate = getReview(reviewId);
		toUpdate.setTitle(review.getTitle());
		toUpdate.setReviewText(review.getReviewText());
		toUpdate.setRating(review.getRating());
		
		System.out.println("review.getTitle()" + review.getTitle() );
		System.out.println("review.getReviewText()" + review.getReviewText() );
		System.out.println("review.getRating()" + review.getRating() );
		reviewRepository.save(toUpdate);
	}

	@Transactional
	public List<Review> getAllReview(User user) {
		return reviewRepository.findAll();
	}

	@Transactional
	public List<Review> getReviewByUser(User user) {
		return reviewRepository.getReviewByUser(user);
	}

	public List<Review> findAll() {
		return reviewRepository.findAll();
	}

}
