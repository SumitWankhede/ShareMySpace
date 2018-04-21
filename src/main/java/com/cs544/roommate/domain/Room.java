package com.cs544.roommate.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id;


    @NotNull
    private int price;
    private int utility;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private double roomSquare;

    private int furnishedStatus;

    private Date availableDate;

    private int minMonths;

    private int roommateCount;

    private Byte[] poster;
}
