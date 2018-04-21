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

    private String address;

    private String title;
    private String decription;

    private int countBedRooms;
    private int countBathRooms;
    private int countAvailableRooms;

    private Date createdDate;
    private Date updatedDate;

    @OneToMany
    private List<Review> reviews = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @OneToMany(mappedBy = "property")
    private List<Amenities> amenities = new ArrayList<>();

}
