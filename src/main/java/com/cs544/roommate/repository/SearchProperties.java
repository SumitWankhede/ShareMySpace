package com.cs544.roommate.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import com.cs544.roommate.domain.Property;

@Repository
public class SearchProperties {
	@Autowired
	private static EntityManager em;

	public static List<Property> search(String location, String typeOfRoom, int noOfRooms, int budgetMin, int budgetMax) {

		String sql = "SELECT distinct p FROM property p " + " WHERE 1 = 1";

		if (!StringUtils.isEmpty(location)) {
			sql += " AND LOWER(p.area) like CONCAT('%', LOWER(:location), '%')";
		}
		if (!StringUtils.isEmpty(typeOfRoom) && !"Any".equals(typeOfRoom)) {
			sql += " AND p.room_type = :typeOfRoom ";
		}
		if (noOfRooms >= 1) {
			sql += " AND p.available_rooms = :noOfRooms ";
		}
		if (budgetMin >= 1 && budgetMax >= 1) {
			sql += " AND p.room_price BETWEEN :budgetMin AND :budgetMax";
		}

		TypedQuery<Property> query = em.createQuery(sql, Property.class);

		if (!StringUtils.isEmpty(location)) {
			query.setParameter("location", location);
		}
		if (!StringUtils.isEmpty(location) && !"ALL".equals(location)) {
			query.setParameter("location", location);
		}
		if (noOfRooms >= 1) {
			query.setParameter("noOfRooms", noOfRooms);
		}
		if (budgetMin >= 1) {
			query.setParameter("budgetMin", budgetMin);
		}
		if (budgetMax >= 1) {
			query.setParameter("budgetMax", budgetMax);
		}
		return query.getResultList();
	}
}
