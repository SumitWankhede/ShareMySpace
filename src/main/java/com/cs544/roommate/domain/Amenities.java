package com.cs544.roommate.domain;


import javax.persistence.*;

@Entity
@Table(name= "amenities")
public class Amenities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="amenitiesName")
    private String name;

    @ManyToOne
    private Property property;
}
