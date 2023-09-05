package com.myProject.mapper;

import com.myProject.dto.H_REQUESTS_Dto;
import com.myProject.model.H_REQUESTS;
import com.myProject.repositories.H_REQUESTS_Repo;
import com.myProject.repositories.H_USERS_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class H_REQUESTS_Mapper {

    @Autowired
    H_REQUESTS_Repo h_requests_repo;

    @Autowired
    H_USERS_Repo h_users_repo;

    public H_REQUESTS_Dto hRequestsDto(H_REQUESTS h_requests)
    {
        H_REQUESTS_Dto r_dto = new H_REQUESTS_Dto();

        r_dto.setID((int)h_requests.getID());
        r_dto.setIDMEH(h_users_repo.findByID(h_requests.getIDMEH()).getNAME_FIRST() + " " + h_users_repo.findByID(h_requests.getIDMEH()).getNAME_LAST());
        r_dto.setIDDIS(h_users_repo.findByID(h_requests.getIDDIS()).getNAME_FIRST() + " " + h_users_repo.findByID(h_requests.getIDDIS()).getNAME_LAST());
        r_dto.setIDMAG(h_users_repo.findByID(h_requests.getIDMAG()).getNAME_FIRST());
        r_dto.setMAGAdress(h_users_repo.findByID(h_requests.getIDMAG()).getNAME_LAST());
        r_dto.setSTATUS(h_requests.getSTATUS());
        r_dto.setDESC(h_requests.getDESC());
        r_dto.setNAME(h_requests.getNAME());
        r_dto.setCHEK(h_requests.isCHEK());

        return r_dto;
    }

}
