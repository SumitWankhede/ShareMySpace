package com.cs544.roommate.domain;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Review2 implements Serializable{

    @Id
   
    private long id;

    private int rating;
   
    private String reviewText;
   
    public Review2() {
    
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
    
   
 
}
