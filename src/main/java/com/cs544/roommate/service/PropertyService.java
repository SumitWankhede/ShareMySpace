package com.cs544.roommate.service;

import java.util.Collection;

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

	@Override
	public Collection<Property> getPropertyList() {
		return propertyDao.findAll();
	}

	@Override
	public void addProperty(Property property) {
		propertyDao.saveAndFlush(property);
	}

	@Override
	public Property getProperty(int id) {
		return propertyDao.findOne(id);
	}

	@Override
	public void updateProperty(Property property) {
		propertyDao.save(property);
	}

	@Override
	public void removeProperty(int id) {
		propertyDao.delete(id);
	}

}
