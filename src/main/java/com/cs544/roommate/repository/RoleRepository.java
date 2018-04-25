/**
 * Created by Amartuvshin Bold on 2018-04-21.
 */
package com.cs544.roommate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs544.roommate.domain.Role;


@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer> {
}
