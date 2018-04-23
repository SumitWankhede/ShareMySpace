package com.cs544.roommate.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


import java.util.Date;
import java.util.List;

@Embeddable
public class Room {

    @NotNull
    private double roomPrice;
    private double utilitiesPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private double area;

    private int furnishedStatus;

    @Temporal(TemporalType.DATE)
    private Date availableDate;

    private int noOfRoommates;

    @Lob
    private Byte[] image;

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public double getUtilitiesPrice() {
		return utilitiesPrice;
	}

	public void setUtilitiesPrice(double utilitiesPrice) {
		this.utilitiesPrice = utilitiesPrice;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getFurnishedStatus() {
		return furnishedStatus;
	}

	public void setFurnishedStatus(int furnishedStatus) {
		this.furnishedStatus = furnishedStatus;
	}

	public Date getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}

	public int getNoOfRoomates() {
		return noOfRoommates;
	}

	public void setNoOfRoomates(int noOfRoomates) {
		this.noOfRoommates = noOfRoomates;
	}

	public int getNoOfRoommates() {
		return noOfRoommates;
	}

	public void setNoOfRoommates(int noOfRoommates) {
		this.noOfRoommates = noOfRoommates;
	}

	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}

	
    
}
