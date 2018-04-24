package com.cs544.roommate.utils;

public class SearchParam {
	  private String location;
	  private String typeOfRoom;
	  private int noOfRooms;
	  private int budgetMin;
	  private int budgetMax;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTypeOfRoom() {
		return typeOfRoom;
	}
	public void setTypeOfRoom(String typeOfRoom) {
		this.typeOfRoom = typeOfRoom;
	}
	public int getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	public int getBudgetMin() {
		return budgetMin;
	}
	public void setBudgetMin(int budgetMin) {
		this.budgetMin = budgetMin;
	}
	public int getBudgetMax() {
		return budgetMax;
	}
	public void setBudgetMax(int budgetMax) {
		this.budgetMax = budgetMax;
	}
	  
	  
}

