package com.cs544.roommate.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

//@Entity
//public class Tenant extends User {
//	private String userType;
//	
//	@OneToMany(mappedBy = "user")
//	private List<Review> reviews = new ArrayList<>();
//
//	public String getUserType() {
//		return userType;
//	}
//
//	public void setUserType(String userType) {
//		this.userType = userType;
//	}
//
//	public void addReview(Review review) {
//		reviews.add(review);
//		review.setUser(this);
//	}
//	
//	public void removeReview(Review review) {
//		review.setUser(null);
//		this.reviews.remove(review);
//	}
//	
//	public List<Review> getReviews(){
//		return Collections.unmodifiableList(reviews);
//	}
//}
