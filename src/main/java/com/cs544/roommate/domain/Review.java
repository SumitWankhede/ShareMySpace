package com.cs544.roommate.domain;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull
    private int rating;
    @NotNull
    private String reviewText;
    private Date date;
    private Date fromDate;
    private Date toDate;

    @ManyToOne
   // @Valid
    private Property property;
    
    @OneToOne
   // @Valid
    private Tenant user;
    
    public Review() {
    	date = new Date();
    }

	public int getId() {
		return id;
		
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = new Date();
		//this.date = date;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Tenant getUser() {
		return user;
	}

	public void setUser(Tenant user) {
		this.user = user;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		System.out.println("fromDate : " + fromDate);
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		System.out.println("toDate : " + toDate);
		this.toDate = toDate;
	}
    
	
	

}
