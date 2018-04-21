package com.cs544.roommate.domain;


import javax.persistence.*;

@Entity
@Table(name="occupation")
public class Occupation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String occupationName;

}
