// Dont need this class.

package com.cs544.roommate.domain;


import javax.persistence.*;

@Entity
@Table(name="occupation")
public class Occupation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String occupationName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOccupationName() {
		return occupationName;
	}

	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}
    
    

}
