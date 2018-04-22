package com.cs544.roommate.service;

import java.util.List;

import com.cs544.roommate.domain.Property;
import com.cs544.roommate.domain.Review;
import com.cs544.roommate.domain.User;

public interface IReviewService {
	
	public void saveReview(Review review);
	public List<Review> getReviewByProperty(Property property);
	public List<Review> getReviewByUser(User user);
	public List<Review> getAllReview(User user);
	public void deleteReview(long reviewId);
}
