/**
 * Created by Amartuvshin Bold on 2018-04-21.
 */
package com.cs544.roommate.repository;

import com.cs544.roommate.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer> {
}
