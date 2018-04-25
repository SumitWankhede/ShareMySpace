package com.cs544.roommate;


import com.cs544.roommate.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoommateAopBasicApplication {
    @Autowired
    User user;
    @Test
    public void contextLoads() {
        user.setName("amar");
        user.setRole(2);
        user.setPassword("password");
        user.setEnabled(true);
        user.setAge(24);
        user.setEmail("amar@gmail.com");
        user.setPrice(123);
        user.setGender("male");
        user.setPhone("132-123-1234");
    }

}
