package com.myProject.controllers;

import com.myProject.config.H_REQUESTS_Conf;
import com.myProject.dto.H_REQUESTS_Dto;
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
public class MehController {

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

    @GetMapping("/meh/meh_redy/{id}")
    public String reqests(@PathVariable("id") int id, Model model) {
        H_USERS h_user = h_authService.login_datas(loginService.getId());
        List<H_REQUESTS_Dto> h_rec = hRequestsService.h_requests_meh_r(h_user.getID());
        model.addAttribute("account", h_user);
        model.addAttribute("contrs", h_rec);
        model.addAttribute("isNotCorrect", false);

        return "meh/meh_redy";
    }

    @GetMapping("/meh/reqest/{id}")
    public String reqest(@PathVariable("id") int id, Model model){

        H_USERS h_user= h_authService.login_datas(loginService.getId());
        H_REQUESTS_Dto h_rec = hRequestsService.h_request(id);
        model.addAttribute("account", h_user);
        model.addAttribute("contrs", h_rec);
        model.addAttribute("isNotCorrect", false);

        return "meh/reqest";
    }

    @GetMapping("/meh/meh_activ/{id}")
    public String reqests_act(@PathVariable("id") int id, Model model) {
        H_USERS h_user = h_authService.login_datas(loginService.getId());
        List<H_REQUESTS_Dto> h_rec = hRequestsService.h_requests_meh_a(h_user.getID());
        model.addAttribute("account", h_user);
        model.addAttribute("contrs", h_rec);
        model.addAttribute("isNotCorrect", false);

        return "meh/meh_activ";
    }

    @GetMapping("/meh/reqest_act/{id}")
    public String reqest_act(@PathVariable("id") int id, Model model){

        H_USERS h_user= h_authService.login_datas(loginService.getId());
        H_REQUESTS_Dto h_rec = hRequestsService.h_request(id);
        model.addAttribute("account", h_user);
        model.addAttribute("contrs", h_rec);
        model.addAttribute("req",new H_REQUESTS());
        model.addAttribute("isNotCorrect", false);

        return "meh/reqest_act";
    }

    @RequestMapping(value="/meh/reqest_act/{id}", method = RequestMethod.POST)
    public String newreq(@ModelAttribute("req") H_REQUESTS req, @PathVariable("id") int id, Model model, RedirectAttributes attributes){

        H_REQUESTS h_requests = h_requests_repo.findByID(loginService.getId());

        h_requests.setDESC(h_requests.getDESC() + "\n" + req.getDESC());
        h_requests.setSTATUS(req.getSTATUS());

        hRequestsConf.update(h_requests);

        H_USERS h_user= h_authService.login_datas(loginService.getId());
        List<H_REQUESTS_Dto> h_rec = hRequestsService.h_requests_meh_a(h_user.getID());
        model.addAttribute("account", h_user);
        model.addAttribute("contrs", h_rec);
        model.addAttribute("isNotCorrect", false);
        return "redirect:/meh/meh_activ/" + h_user.getID();
    }

    @GetMapping(value="/meh/reqest_end/{id}")
    public String endreq(@PathVariable("id") int id, Model model, RedirectAttributes attributes){

        H_REQUESTS h_requests = h_requests_repo.findByID(loginService.getId());

        h_requests.setSTATUS("Завершено");

        hRequestsConf.update(h_requests);

        H_USERS h_user= h_authService.login_datas(loginService.getId());
        List<H_REQUESTS_Dto> h_rec = hRequestsService.h_requests_meh_r(h_user.getID());
        model.addAttribute("account", h_user);
        model.addAttribute("contrs", h_rec);
        model.addAttribute("isNotCorrect", false);
        return "redirect:/meh/meh_redy/" + h_user.getID();
    }

}
