package com.cs544.roommate.domain;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

//@Entity
//public class Lanloard extends  User{
//
//	private String userType;
//	
//	@OneToMany
//    private List<Property> propertyList = new ArrayList<>();
//	
//	public String getUserType() {
//		return userType;
//	}
//	public void setUserType(String userType) {
//		this.userType = userType;
//	}
//	public List<Property> getPropertyList() {
//		return propertyList;
//	}
//	public void setPropertyList(List<Property> propertyList) {
//		this.propertyList = propertyList;
//	}
//    
//    
//}
