/**
 * Created by Amartuvshin Bold on 2018-04-21.
 */
package com.cs544.roommate.service;

import com.cs544.roommate.domain.Role;
import com.cs544.roommate.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role findOne(int id) {
        return roleRepository.findOne(id);
    }

}
