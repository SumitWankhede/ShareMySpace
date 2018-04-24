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
	private EntityManager em;

	public List<Property> search(String location, String typeOfRoom, int noOfRooms, int budgetMin, int budgetMax) {

		String sql = "select distinct p from property p " + " where 1 = 1";

		if (!StringUtils.isEmpty(location)) {
			sql += " and LOWER(p.area) like CONCAT('%', LOWER(:location), '%')";
		}
		if (!StringUtils.isEmpty(typeOfRoom) && !"Any".equals(typeOfRoom)) {
			sql += " and p.room_type = :typeOfRoom";
		}
		if (noOfRooms >= 1) {
			sql += " and p.available_rooms = :noOfRooms";
		}
		if (budgetMin >= 1) {
			sql += " and p.room_price >= :budgetMin";
		}
		if (budgetMax >= 1) {
			sql += " and p.room_price <= :budgetMax";
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
