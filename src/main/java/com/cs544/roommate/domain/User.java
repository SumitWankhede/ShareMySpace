package com.cs544.roommate.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract class User {
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    private int age;
    private int gender; // 0- Male 1-Female
    private int phoneNumber;

}
