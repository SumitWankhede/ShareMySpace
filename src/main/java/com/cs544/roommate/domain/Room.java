package com.cs544.roommate.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id;

    @NotNull
    private double roomPrice;
    private double utilitiesPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private double area;

    private int furnishedStatus;

    private Date availableDate;

    private int noOfRoomates;

    private List<Byte[]> images;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		return noOfRoomates;
	}

	public void setNoOfRoomates(int noOfRoomates) {
		this.noOfRoomates = noOfRoomates;
	}

	public List<Byte[]> getImages() {
		return images;
	}

	public void setImages(List<Byte[]> images) {
		this.images = images;
	}
    
    
}
