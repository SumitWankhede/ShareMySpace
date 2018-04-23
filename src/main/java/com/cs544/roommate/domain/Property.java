package com.cs544.roommate.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
   
    private String title;
    private String description;

    private int totalBedRooms;
    private int totalBathRooms;
    private int availableRooms;

    private Date createdDate;
    private Date updatedDate;
    
    @Embedded
    private Room room;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany
    private List<Review> reviews = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    public Property() {
    	this.updatedDate = new Date();
    }
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
		address.setProperty(this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalBedRooms() {
		return totalBedRooms;
	}

	public void setTotalBedRooms(int totalBedRooms) {
		this.totalBedRooms = totalBedRooms;
	}

	public int getTotalBathRooms() {
		return totalBathRooms;
	}

	public void setTotalBathRooms(int totalBathRooms) {
		this.totalBathRooms = totalBathRooms;
	}

	public int getAvailableRooms() {
		return availableRooms;
	}

	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
  

}
