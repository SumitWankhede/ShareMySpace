package com.cs544.roommate.controller;

import com.cs544.roommate.simple.Team;
import com.cs544.roommate.simple.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class TeamController {

    @Autowired
    private TeamRepo teamRepo;
    @RequestMapping("/team")
    public ModelAndView doTeam(){
        ModelAndView mv = new ModelAndView("team");
        mv.addObject("lists",teamRepo.findAll());
        return mv;
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("teamID") String teamID,@RequestParam("name") String name){
        ModelAndView mv = new ModelAndView("redirect:/team");
        Team team ;
        if(!teamID.isEmpty()){
            team = (Team)teamRepo.findOne(Integer.parseInt(teamID));
        }else {
           team = new Team();
        }
        team.setName(name);
        teamRepo.save(team);
        return mv;
    }

    @RequestMapping(value="/view/{teamID}",method = RequestMethod.GET)
    public ModelAndView doView(@PathVariable("teamID") int teamID ){
        ModelAndView mv = new ModelAndView("view");
        mv.addObject("lists",teamRepo.findOne(teamID));
        return mv;
    }

    @RequestMapping(value="/edit/{teamID}",method = RequestMethod.GET)
    public ModelAndView doEdit(@PathVariable("teamID") int teamID ){
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("lists",teamRepo.findOne(teamID));
        return mv;
    }

    @RequestMapping(value="/delete/{teamId}",method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("teamId") int teamId ){
        ModelAndView mv = new ModelAndView("redirect:/team");
        teamRepo.delete(teamId);
        return mv;
    }

}
