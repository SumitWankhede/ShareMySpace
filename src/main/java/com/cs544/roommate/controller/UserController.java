/**
 * Created by Amartuvshin Bold on 2018-04-21.
 */
package com.cs544.roommate.controller;

import com.cs544.roommate.domain.Role;
import com.cs544.roommate.domain.User;
import com.cs544.roommate.service.RoleService;
import com.cs544.roommate.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.ModalExclude;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView doUserList(Model model) {
        ModelAndView mv = new ModelAndView("admin/user/index");
        model.addAttribute("userList", userService.findAll());
        return mv;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView doEdit(Model model, @ModelAttribute("user") User user,
                            @RequestParam(value = "id", required = false) Long id) {
        ModelAndView mv = new ModelAndView("admin/user/create");
        if (id != null) {
            User updatedUser = userService.findById(id);
            if (updatedUser.getRoles().size() == 1) {
                updatedUser.setRole(updatedUser.getRoles().get(0).getId());
            }
            model.addAttribute("user", updatedUser);
        }
        return mv;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView doCreate(Model model, @ModelAttribute("user") User user) {
        ModelAndView mv = new ModelAndView("redirect:/admin/user/");
        User existingUser = userService.findByEmail(user.getEmail());
        if(existingUser != null && user.getId() == 0) {
            ModelAndView mv2 = new ModelAndView("admin/user/create");
            return mv2;
        } else {
            if (user.getId() != 0 && user.getPassword().isEmpty()) {
                user.setPassword(existingUser.getPassword());
            }
            user.clearRoles();
            user.addRole(roleService.findOne(user.getRole()));
            userService.save(user);
        }
        return mv;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ModelAndView doDelete(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("redirect:/admin/user/");
        userService.delete(id);
        return mv;
    }

    @ModelAttribute("roles")
    public List<Role> getRoles() {
        return roleService.getAll();
    }
}
