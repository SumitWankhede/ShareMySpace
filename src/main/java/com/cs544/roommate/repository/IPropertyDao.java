package com.cs544.roommate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs544.roommate.domain.Property;

// Not completed!!!

public interface IPropertyDao extends JpaRepository<Property, Integer> {

//	@Query("SELECT distinct p FROM property p "
//		      + " WHERE "
//		      + " LOWER(p.area) LIKE CONCAT('%', LOWER(:location), '%') "
//		      + "OR p.room_type = :typeOfRoom " 
//		      + "OR p.available_rooms = :noOfRooms "
//		      + "OR p.room_price  BETWEEN :budgetMin AND :budgetMax"
//		      )
//		  List<Property> search(@Param("location") String location,
//		      @Param("typeOfRoom") PropertyType typeOfRoom, @Param("noOfRooms") int noOfRooms,
//		      @Param("budgetMin") int budgetMin, @Param("budgetMax") int budgetMax);
	
}