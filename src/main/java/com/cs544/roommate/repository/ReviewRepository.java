package com.cs544.roommate.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cs544.roommate.domain.Property;
import com.cs544.roommate.domain.Review;
//import com.cs544.roommate.domain.Tenant;
import com.cs544.roommate.domain.User;

import java.util.List;

import org.springframework.data.jpa.repository.*;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
	List<Review> getReviewByProperty(Property property);
	List<Review> getReviewByUser(User user);
	//List<Review> getAllReview(User user);
	
	
}
