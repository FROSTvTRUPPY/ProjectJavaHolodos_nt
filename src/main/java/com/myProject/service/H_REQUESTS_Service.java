package com.myProject.service;

import com.myProject.dto.H_REQUESTS_Dto;
import com.myProject.mapper.H_REQUESTS_Mapper;
import com.myProject.model.H_REQUESTS;
import com.myProject.repositories.H_REQUESTS_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class H_REQUESTS_Service {

    @Autowired
    H_REQUESTS_Repo h_requests_repo;

    @Autowired
    H_REQUESTS_Mapper mapper;

    public List<H_REQUESTS_Dto> h_requests(int mag){
        List<H_REQUESTS_Dto> list_r = new ArrayList<>();

        for (H_REQUESTS req : h_requests_repo.findAllByIDMAGAndSTATUS(mag, "Ожидание")){
            list_r.add(mapper.hRequestsDto(req));
        }


        System.out.println(h_requests_repo.findAllByIDMAGOrderBySTATUS(1));

        System.out.println(h_requests_repo.findAllByIDMAGOrderBySTATUS(mag));

        for (H_REQUESTS req : h_requests_repo.findAllByIDMAGOrderBySTATUS(mag)){
            if(!req.getSTATUS().equals("Ожидание"))
                list_r.add(mapper.hRequestsDto(req));
        }

        return list_r;
    }

    public List<H_REQUESTS_Dto> h_requests_meh_r(int meh){
        List<H_REQUESTS_Dto> list_r = new ArrayList<>();

        for (H_REQUESTS req : h_requests_repo.findAllByIDMEHAndSTATUS(meh, "Завершено")){
            list_r.add(mapper.hRequestsDto(req));
        }


        /*for (H_REQUESTS req : h_requests_repo.findAllByIDMAGOrderBySTATUS(meh)){
            if(!req.getSTATUS().equals("Ожидание"))
                list_r.add(mapper.hRequestsDto(req));
        }*/

        return list_r;
    }

    public List<H_REQUESTS_Dto> h_requests_meh_a(int meh){
        List<H_REQUESTS_Dto> list_r = new ArrayList<>();

        /*for (H_REQUESTS req : h_requests_repo.findAllByIDMEHAndSTATUS(meh, "Завершено")){
            list_r.add(mapper.hRequestsDto(req));
        }*/


        for (H_REQUESTS req : h_requests_repo.findAllByIDMEHOrderBySTATUS(meh)){
            if(!req.getSTATUS().equals("Завершено"))
                list_r.add(mapper.hRequestsDto(req));
        }

        return list_r;
    }

    public H_REQUESTS_Dto h_request(int id){
        H_REQUESTS_Dto dto = mapper.hRequestsDto(h_requests_repo.findByID(id));
        return dto;
    }

}
