package com.myProject.controllers;

import com.myProject.config.H_REQUESTS_Conf;
import com.myProject.config.H_Role;
import com.myProject.dto.H_KeyAuth;
import com.myProject.dto.H_REQUESTS_Dto;
import com.myProject.dto.H_SDate_Dto;
import com.myProject.model.H_REQUESTS;
import com.myProject.model.H_USERS;
import com.myProject.repositories.H_REQUESTS_Repo;
import com.myProject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MagController {

    @Autowired
    H_USERS_Service h_USERS_service;

    @Autowired
    private H_AuthService h_authService;

    @Autowired
    public H_LoginService loginService;

    @Autowired
    public H_CONTR_Service h_contr_service;

    @Autowired
    public H_REQUESTS_Service hRequestsService;

    @Autowired
    public H_REQUESTS_Repo h_requests_repo;

    @Autowired
    H_REQUESTS_Conf hRequestsConf;


    @GetMapping("/mag/mag/{id}")
    public String mag(@PathVariable("id") int id, Model model){
        H_USERS h_users= h_authService.login_datas(id);

        List<H_SDate_Dto> h_contr = h_contr_service.get_H_SDate_Dto(id);

        model.addAttribute("account", h_users);
        model.addAttribute("contrs", h_contr);
        model.addAttribute("isNotCorrect", false);

        return "mag/mag";
    }

    @GetMapping("/mag/reqests/{id}")
    public String reqests(@PathVariable("id") int id, Model model){
        H_USERS h_user= h_authService.login_datas(loginService.getId());
        List<H_REQUESTS_Dto> h_rec = hRequestsService.h_requests(h_user.getID());
        model.addAttribute("account", h_user);
        model.addAttribute("contrs", h_rec);
        model.addAttribute("isNotCorrect", false);

        return "mag/reqests";
    }

    @GetMapping("/mag/reqest/{id}")
    public String reqest(@PathVariable("id") int id, Model model){

        H_USERS h_user= h_authService.login_datas(loginService.getId());
        H_REQUESTS_Dto h_rec = hRequestsService.h_request(id);
        model.addAttribute("account", h_user);
        model.addAttribute("contrs", h_rec);
        model.addAttribute("isNotCorrect", false);

        return "mag/reqest";
    }

    @GetMapping("/mag/newreq")
    public String newreq(Model model){
        H_USERS h_user= h_authService.login_datas(loginService.getId());
        model.addAttribute("account", h_user);
        model.addAttribute("isNotCorrect", false);
        model.addAttribute("req", new H_REQUESTS());
        return "/mag/newreq";
    }

    @RequestMapping(value="/mag/newreq", method = RequestMethod.POST)
    public String newreq(@ModelAttribute("req") H_REQUESTS req, Model model, RedirectAttributes attributes){
        req.setIDMEH(7);
        req.setIDDIS(8);
        req.setIDMAG(loginService.getId());
        req.setSTATUS("Ожидание");
        req.setCHEK(false);

        hRequestsConf.save(req);

        H_USERS h_user= h_authService.login_datas(loginService.getId());
        List<H_REQUESTS_Dto> h_rec = hRequestsService.h_requests(h_user.getID());
        model.addAttribute("account", h_user);
        model.addAttribute("contrs", h_rec);
        model.addAttribute("isNotCorrect", false);
        return "redirect:/mag/reqests/" + h_user.getID();
    }
}
