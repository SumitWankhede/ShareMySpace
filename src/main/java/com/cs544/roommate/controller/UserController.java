/**
 * Created by Amartuvshin Bold on 2018-04-21.
 */
package com.cs544.roommate.controller;

import com.cs544.roommate.domain.Role;
import com.cs544.roommate.domain.User;
import com.cs544.roommate.service.RoleService;
import com.cs544.roommate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/user/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String get(Model model, @ModelAttribute("user") User user,
                      @RequestParam(value = "id", required = false) Long id) {
        if (id != null) {
            User updatedUser = userService.findById(id);
            if (updatedUser.getRoles().size() == 1) {
                updatedUser.setRole(updatedUser.getRoles().get(0).getId());
            }
            model.addAttribute("user", updatedUser);
        }
        return "admin/user/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute("user") User user) {
        String view = "redirect:/admin/user/";
        User existingUser = userService.findByEmail(user.getEmail());
        if(existingUser != null && user.getId() == 0) {
            model.addAttribute("errorMsg", "This email already exists. Please use another email.");
            view = "admin/user/create";
            return view;
        } else {
            if (user.getId() != 0 && user.getPassword().isEmpty()) {
                user.setPassword(existingUser.getPassword());
            }
            user.clearRoles();
            user.addRole(roleService.findOne(user.getRole()));
            userService.save(user);
        }
        return view;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin/user/";
    }

    @ModelAttribute("roles")
    public List<Role> getRoles() {
        return roleService.getAll();
    }
}
