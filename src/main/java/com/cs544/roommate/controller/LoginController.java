/**
 * Created by Amartuvshin Bold on 2018-04-21.
 */

package com.cs544.roommate.controller;


import com.cs544.roommate.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login(@ModelAttribute("user") User user) {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
}
