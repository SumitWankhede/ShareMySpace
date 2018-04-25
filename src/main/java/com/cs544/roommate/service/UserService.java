/**
 * Created by Amartuvshin Bold on 2018-04-21.
 */
package com.cs544.roommate.service;

import com.cs544.roommate.domain.Property;
import com.cs544.roommate.domain.Review;
import com.cs544.roommate.domain.User;
import com.cs544.roommate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements  IUserService{

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findOne(id);
    }
    @Override
    public User getUserByEmail(String email) {
        List<User> users = userRepository.findOneByEmail(email);
        if (users.size() == 1) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Transactional
    public void delete(long id) {
        User user = userRepository.findOne(id);
        user.clearRoles();
        userRepository.delete(user);
    }
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    public User getUserById(String userId) {
		return userRepository.getOne(Long.parseLong(userId));
	}
    
    public void addReview(String userId, Review review) {
		User toUpdate = getUserById(userId);
		toUpdate.addReview(review);
		review.setUser(toUpdate);
		userRepository.save(toUpdate);

	}
}
