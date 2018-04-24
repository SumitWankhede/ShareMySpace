/**
 * Created by Amartuvshin Bold on 2018-04-21.
 */

package com.cs544.roommate.controller;


import com.cs544.roommate.config.SessionListener;
import com.cs544.roommate.config.SmtpMailSender;
import com.cs544.roommate.domain.User;
import com.cs544.roommate.service.RoleService;
import com.cs544.roommate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller
@RequestMapping("/me/")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SessionListener secSessionListener;

    @Autowired
    private SmtpMailSender mailSender;


    // Update Account
    @GetMapping({"/account/update"})
    public String account(Model model) {
        User user = userService.findByEmail(secSessionListener.getUser().getEmail());
        model.addAttribute("user", user);
        return "myaccount/account";
    }

    @PostMapping("/account/update")
    public String updateAccount(Model model, @ModelAttribute("user") User user) {
        User existingUser = userService.findByEmail(secSessionListener.getUser().getEmail());
        if (user.getPassword() ==null || user.getPassword().isEmpty()) {
            user.setPassword(existingUser.getPassword());
        }
        userService.save(user);
        return "redirect:/me/account/update";
    }

    // Sign up
    @GetMapping({"/account/signup"})
    public String signUp(Model model, @ModelAttribute("user") User user) {
        // set the default role for a new user
        user.addRole(roleService.findOne(2));
        user.setEnabled(true);

        return "myaccount/signup";
    }

    @PostMapping("/account/signup")
    public String createNewAccount(Model model, @ModelAttribute("user") User user) {
        String view = "myaccount/signup";
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null) {
            model.addAttribute("errorMsg", "This email already exists. Please use another email.");
            return view;
        }
        userService.save(user);
        model.addAttribute("infoMsg",
                "Your new account has been created sucessfully. Click here to login");
        try{
            mailSender.sendMail(user.getEmail(),"Login information","Congratulations~!. Welcome to Share My Space website.. ");
        }catch (MessagingException e){
            e.printStackTrace();
        }
        model.addAttribute("emailMsg","Mail sending...");
        return view;

    }
}
