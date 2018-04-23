package com.cs544.roommate.service;

import java.util.Collection;
import java.util.Optional;

import com.cs544.roommate.domain.Property;

public interface IPropertyService {

	public Collection<Property> getPropertyList();
	public void addProperty(Property property);
	public Optional<Property> getProperty(int id);
	public void updateProperty(Property property);
	public void removeProperty(int id);
}
