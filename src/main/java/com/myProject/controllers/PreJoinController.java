package com.myProject.controllers;

import com.myProject.config.H_Role;
import com.myProject.dto.H_KeyAuth;
import com.myProject.dto.H_USERS_Dto;
import com.myProject.dto.KeyAuth;
import com.myProject.model.H_USERS;
import com.myProject.service.H_AuthService;
import com.myProject.service.H_LoginService;
import com.myProject.service.H_USERS_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PreJoinController {

    @Autowired
    H_USERS_Service h_USERS_service;

    @Autowired
    private H_AuthService h_authService;

    @Autowired
    public H_LoginService loginService;

    /*@GetMapping("/timed")
        public String prejoin(Model model){
            List<H_USERS_Dto> h_users = h_USERS_service.get_H_USERS();
            model.addAttribute("h_users",h_users);
            return "timed";
        }*/

    @GetMapping("/pre_join")
    public String prejoin(Model model){
        model.addAttribute("account", new H_USERS());
        model.addAttribute("isNotCorrect", false);
        return "pre_join";
    }

    @RequestMapping(value="/pre_join", method = RequestMethod.POST)
    public String prejoin(@ModelAttribute H_USERS account, Model model, RedirectAttributes attributes){

        H_KeyAuth keyAuth = h_authService.login(account.getLOGG(), account.getPASS());
        H_Role h_post = h_authService.login_r(account.getLOGG(), account.getPASS());
        if(keyAuth==null){
            model.addAttribute("isNotCorrect", true);
            return "pre_join";
        }

        attributes.addFlashAttribute("key", keyAuth);
        attributes.addFlashAttribute("role", h_post);
        return "redirect:/pre_join/auth";
    }

    @GetMapping()
    @RequestMapping(value = "/pre_join/auth", method = RequestMethod.GET)
    public String loginGet(Model model){
        H_KeyAuth key = (H_KeyAuth) model.asMap().get("key");
        H_Role h_post = (H_Role) model.asMap().get("role");

        if(loginService.login(key)) {

            if (h_post == H_Role.MAG)
                return "redirect:/mag/mag/" + key.getID();

            else if (h_post == H_Role.MEH)
                return "redirect:/meh/meh_redy/" + key.getID();

            else if (h_post == H_Role.DIS)
                return "redirect:/dis/dis/" + key.getID();

            else if (h_post == H_Role.BIS)
                return "redirect:/bis/bis/" + key.getID();
        }
        return "redirect:/pre_join";
    }

    @GetMapping("/h_logout")
    public String logout(){
        loginService.logout();
        return "redirect:/pre_join";
    }

}
