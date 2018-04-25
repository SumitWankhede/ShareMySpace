/**
 * Created by Amartuvshin Bold on 2018-04-21.
 */


package com.cs544.roommate.config;

import com.cs544.roommate.domain.User;
import com.cs544.roommate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component("sessionListener")
public class SessionListener {

  @Autowired
  UserService service;

  @Autowired
  HttpSession session;

  public User getUser() {
    if (session.getAttribute("loggedUser") != null) {
      return (User) session.getAttribute("loggedUser");
    }
    User user = service.getUserByEmail(getPrincipal());
    session.setAttribute("loggedUser", user);
    return user;

  }

  private String getPrincipal() {
    String username = null;
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal instanceof UserDetails) {
        username = ((UserDetails) principal).getUsername();
    } else {
        username = principal.toString();
    }
    return username;
  }

}


