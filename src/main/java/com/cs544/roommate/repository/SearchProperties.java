package com.cs544.roommate.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.cs544.roommate.domain.Property;

@Repository
public class SearchProperties {
	
	@PersistenceContext
	private  EntityManager em;

	public  List<Property> search(String location, String typeOfRoom, int noOfRooms, int budgetMin, int budgetMax) {

		String sql = "SELECT distinct p FROM Property p " + " WHERE 1 = 1";

		
		
		if (!StringUtils.isEmpty(location)  && !"Any".equals(location)) {
			sql += " AND LOWER(p.area) like CONCAT('%', LOWER(:location), '%')";
		}
		if (!StringUtils.isEmpty(typeOfRoom) && !"Any".equals(typeOfRoom)) {
			sql += " AND p.room_type = :typeOfRoom ";
		}
		if (noOfRooms >= 1) {
			sql += " AND p.available_rooms = :noOfRooms ";
		}
		if (budgetMin >= 0 && budgetMax >= 1) {
			sql += " AND p.room_price BETWEEN :budgetMin AND :budgetMax";
		}
		TypedQuery<Property> query = em.createQuery(sql, Property.class);
		

		if (!StringUtils.isEmpty(location) && !"Any".equals(location)) {
			query.setParameter("location", location);
		}
		if (!StringUtils.isEmpty(typeOfRoom) && !"Any".equals(typeOfRoom)) {
			query.setParameter("typeOfRoom", typeOfRoom);
		}
		if (noOfRooms >= 1) {
			query.setParameter("noOfRooms", noOfRooms);
		}
		if (budgetMin >= 0 && budgetMax >= 1) {
			query.setParameter("budgetMin", budgetMin);
			query.setParameter("budgetMax", budgetMax);
		}
		
		List<Property> tempProperty = new ArrayList<>();
		if(query.getResultList().isEmpty())
			return tempProperty;
		else
		return query.getResultList();
	}
}
