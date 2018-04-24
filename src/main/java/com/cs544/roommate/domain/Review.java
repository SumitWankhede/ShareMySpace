package com.cs544.roommate.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyTemporal;
import javax.persistence.Table;
import javax.persistence.TemporalType;

@Entity
@Table(name="Review")
public class Review{

    @Id @GeneratedValue
    private long id;
    private int rating;
    private String reviewText;
    private String title;
    
    @MapKeyTemporal(TemporalType.TIMESTAMP)
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
