package com.cs544.roommate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cs544.roommate.domain.Property;
import com.cs544.roommate.domain.PropertyType;


// Not completed!!!

public interface IPropertyDao extends JpaRepository<Property, Integer> {

//	@Query("select distinct p from property p "
//		      + " where "
//		      + " LOWER(p.area) like CONCAT('%', LOWER(:location), '%') "
//		      + "or p.room_type = :typeOfRoom " 
//		      + "or p.available_rooms = :noOfRooms "
//		      + "or p.room_price >= :budgetMin "
//		      + "or p.room_price <= :budgetMax "
//		      )
//		  List<Property> search(@Param("location") String location,
//		      @Param("typeOfRoom") PropertyType typeOfRoom, @Param("noOfRooms") int noOfRooms,
//		      @Param("budgetMin") int budgetMin, @Param("budgetMax") int budgetMax);
	
}