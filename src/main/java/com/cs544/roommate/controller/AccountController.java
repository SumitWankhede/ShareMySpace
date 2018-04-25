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
    private RoleService roleService;

    @Autowired
    private SessionListener sessionListener;

    @Autowired
    private SmtpMailSender mailSender;

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

    @GetMapping({"/signup"})
    public ModelAndView doSignUp(Model m, @ModelAttribute("user") User user) {
        ModelAndView mv = new ModelAndView("profile/signup");
        user.addRole(roleService.findOne(2));
        user.setEnabled(true);
        return mv;
    }

    @PostMapping("/signup")
    public ModelAndView createAccount(Model model, @ModelAttribute("user") User user) {
        ModelAndView mv = new ModelAndView("profile/signup");
        User users = userService.getUserByEmail(user.getEmail());
        if (users != null) {
           return mv;
        }
        userService.save(user);
        try{
            mailSender.sendMail(user.getEmail(),"Login information","Congratulations~!. Welcome to Share My Space website.. ");
        }catch (MessagingException e){
            e.printStackTrace();
        }
        return mv;
    }
    @ModelAttribute("roles")
    public List<Role> getRoles() {
        return roleService.getAll();
    }
}
