package com.cs544.roommate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs544.roommate.domain.Property;
import com.cs544.roommate.domain.Review;
import com.cs544.roommate.repository.IPropertyDao;
import com.cs544.roommate.repository.SearchProperties;


@Service
public class PropertyService implements IPropertyService {

	private IPropertyDao propertyDao;
	
	@Autowired
	private SearchProperties searchProperties;

	@Autowired
	public void setPropertyDao(IPropertyDao propertyDao) {
		this.propertyDao = propertyDao;
	}

	@Override
	public List<Property> getPropertyList() {
		return propertyDao.findAll();
	}

	@Override
	public void addProperty(Property property) {
		propertyDao.saveAndFlush(property);
	}

	@Override
	public Property getProperty(int id) {
		Property p = propertyDao.findOne(id);
		//ND->
		//Property p = null;
		System.out.println("Find Property : " + p);
		return p;
	}

	@Override
	public void updateProperty(Property property) {
		propertyDao.save(property);
	}

	@Override
	public void removeProperty(int id) {
// ND->	
		propertyDao.delete(id);
	}

	public Property getPropertyById(String propertyId) {
		return propertyDao.getOne((int) Long.parseLong(propertyId));
	}

	public void addReview(String propertyId, Review review) {
		Property updateProperty = getPropertyById(propertyId);
		updateProperty.addReview(review);
		review.setProperty(updateProperty);
		propertyDao.save(updateProperty);

	}

	public List<Property> search(String location, String typeOfRoom, int noOfRooms, int budgetMin, int budgetMax) {
		return searchProperties.search(location, typeOfRoom, noOfRooms, budgetMin, budgetMax);
	}

}
