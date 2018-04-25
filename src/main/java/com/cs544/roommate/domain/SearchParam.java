package com.cs544.roommate.domain;

public class SearchParam {
	  private String location;
	  private String typeOfRoom;
	  private int noOfRooms;
	  private int budgetMin;
	  private int budgetMax;
	  private int budget;
	  
	public void setBudget(int budget) {
		this.budget = budget;
		switch(this.budget) {
		case 1:
			budgetMin=0;
			budgetMax=300;
			break;
		case 2:
			budgetMin=300;
			budgetMax=500;
			break;
		case 3:
			budgetMin=500;
			budgetMax=1000;
			break;
		case 4:
			budgetMin=1000;
			budgetMax=30000;
			break;
			default:
				budgetMin=0;
				budgetMax=0;
		}
	}
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

