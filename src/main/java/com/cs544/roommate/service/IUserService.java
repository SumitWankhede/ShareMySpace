package com.cs544.roommate.service;

import com.cs544.roommate.domain.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    User getUserById(long id);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    User save(User user);
}
