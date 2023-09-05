package com.myProject.service;

import com.myProject.dto.H_CONTR_Dto;
import com.myProject.dto.H_SDate_Dto;
import com.myProject.mapper.H_CONTR_Mapper;
import com.myProject.model.H_CONTR;
import com.myProject.repositories.H_CONTR_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class H_CONTR_Service {

    @Autowired
    H_CONTR_Repo h_contr_repo;

    @Autowired
    H_CONTR_Mapper h_contr_mapper;

    public List<H_CONTR_Dto> get_H_CONTR_byMag(int MagId){
        List<H_CONTR_Dto> h_contr_dtos = new ArrayList<>();

        for (H_CONTR h_contr : h_contr_repo.findAllByMAGIDOrderByID(MagId)){
            h_contr_dtos.add(h_contr_mapper.map_H_CONTR_to_H_CONTR_Dto(h_contr));
        }

        return h_contr_dtos;
    }

    public List<H_SDate_Dto> get_H_SDate_Dto(int MagId){
        List<H_SDate_Dto> h_sDate_dtos = new ArrayList<>();

        for (H_CONTR h_contr : h_contr_repo.findAllByMAGIDOrderByID(MagId)){
            h_sDate_dtos.add(h_contr_mapper.map_H_CONTR_and_H_SDate_to_H_SDate_Dto(h_contr));
        }

        return h_sDate_dtos;
    }

}
