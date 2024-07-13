package com.codegym.furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/login")
    public ModelAndView showFormLogin(){
        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }

    @GetMapping("/index")
    public ModelAndView showAdminIndex(){
        ModelAndView modelAndView = new ModelAndView("/admin/index");
        return modelAndView;
    }
}
