package com.cs544.roommate.domain;


import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

public class Lanloard extends  User{

    private List<Property> propertyList = new ArrayList<>();
}
