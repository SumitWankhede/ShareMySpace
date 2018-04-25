/**
 * Created by Amartuvshin Bold on 2018-04-21.
 */
package com.cs544.roommate.repository;

import com.cs544.roommate.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
	List<User> findOneByEmail(String email);
}
