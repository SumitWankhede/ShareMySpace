/**
 * Created by Amartuvshin Bold on 2018-04-21.
 */

package com.cs544.roommate.controller;


import com.cs544.roommate.config.SessionListener;
import com.cs544.roommate.config.SmtpMailSender;
import com.cs544.roommate.domain.Role;
import com.cs544.roommate.domain.User;
import com.cs544.roommate.service.RoleService;
import com.cs544.roommate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import java.util.List;

@Controller
@RequestMapping("/account/")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionListener sessionListener;


    @GetMapping({"/update"})
    public ModelAndView doHome(Model model) {
        ModelAndView mv = new ModelAndView("profile/account");
        User user = userService.getUserByEmail(sessionListener.getUser().getEmail());
        model.addAttribute("user", user);
        return mv;
    }

    @PostMapping("/update")
    public ModelAndView doUpdate(Model m, @ModelAttribute("user") User user) {
        ModelAndView mv = new ModelAndView("redirect:/me/account/update");
        User users = userService.getUserByEmail(sessionListener.getUser().getEmail());
        if (user.getPassword() ==null || user.getPassword().isEmpty()) {
            user.setPassword(users.getPassword());
        }
        userService.save(user);
        return mv;
    }

}
