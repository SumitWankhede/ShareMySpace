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
    private Long id;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    private String title;
    private String decription;

    private int totalBedRooms;
    private int totalBathRooms;
    private int availableRooms;

    private Date createdDate;
    private Date updatedDate;

    @OneToMany
    private List<Review> reviews = new ArrayList<Review>();

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
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
    

    //@OneToMany(mappedBy = "property")
    //private List<Amenities> amenities = new ArrayList<>();
    
    

}
