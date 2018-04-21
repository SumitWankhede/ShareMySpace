package com.cs544.roommate.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String reviews;
    private Date date;

    @ManyToOne
    private Property property;

}
