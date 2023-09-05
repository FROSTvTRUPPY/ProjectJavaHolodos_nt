package com.myProject.service;

import com.myProject.config.H_USERS_Conf;
import com.myProject.dto.H_USERS_Dto;
import com.myProject.model.H_USERS;
import org.springframework.beans.factory.annotation.Autowired;
import com.myProject.mapper.H_USERS_Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class H_USERS_Service {

    @Autowired
    H_USERS_Conf h_users_conf;

    @Autowired
    H_USERS_Mapper h_users_mapper;

    public List<H_USERS_Dto> get_H_USERS(){
        List<H_USERS_Dto> h_users_dtos = new ArrayList<>();

        for(H_USERS h_user : h_users_conf.findAll()) {
            h_users_dtos.add(h_users_mapper.map_H_USERS_to_H_USERS_Dto(h_user));
        }
        return h_users_dtos;
    }
}
