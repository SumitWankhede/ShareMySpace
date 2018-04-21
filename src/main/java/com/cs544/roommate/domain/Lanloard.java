package com.cs544.roommate.domain;


import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

public class Lanloard extends  User{

	private String userType;
    private List<Property> propertyList = new ArrayList<>();
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public List<Property> getPropertyList() {
		return propertyList;
	}
	public void setPropertyList(List<Property> propertyList) {
		this.propertyList = propertyList;
	}
    
    
}
