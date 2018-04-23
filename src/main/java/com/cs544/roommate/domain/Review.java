package com.cs544.roommate.domain;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Review implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
   // @NotNull
    private int rating;
    //@NotNull
    private String reviewText;
    
    private String title;
    
    private Date date;
  

    @ManyToOne
    @JoinColumn(name="propertyId")
    private Property property;
    
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    
    public Review() {
    	date = new Date();
    	
    }
    
	public long getId() {
		return id;
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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(long id) {
		this.id = id;
	}

}
