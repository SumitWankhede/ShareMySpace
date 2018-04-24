package com.cs544.roommate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cs544.roommate.domain.Property;
import com.cs544.roommate.domain.Review;
//import com.cs544.roommate.domain.Tenant;
import com.cs544.roommate.domain.User;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
	List<Review> getReviewByProperty(Property property);
	List<Review> getReviewByUser(User user);
	
	//List<Review> getAllReview(User user);
	@Query("select review from Review review join fetch review.property property where property.id = :propertyId")
	List<Review> getReviewByPropertyId(@Param("propertyId") int propertyId);
	
}
