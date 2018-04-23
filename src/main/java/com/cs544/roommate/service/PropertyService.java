package com.cs544.roommate.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs544.roommate.domain.Property;
import com.cs544.roommate.repository.IPropertyDao;

@Service
public class PropertyService implements IPropertyService {
	
	private IPropertyDao propertyDao;
	
	@Autowired
	public void setPropertyDao(IPropertyDao propertyDao) {
		this.propertyDao = propertyDao;
	}

	public Collection<Property> getPropertyList() {
		return propertyDao.findAll();
	}

	public void addProperty(Property property) {
		propertyDao.saveAndFlush(property);
	}

	public Property getProperty(int id) {
		return propertyDao.findOne(id);
	}

	public void updateProperty(Property property) {
		propertyDao.save(property);
	}

	public void removeProperty(int id) {
		propertyDao.delete(id);
	}

}
