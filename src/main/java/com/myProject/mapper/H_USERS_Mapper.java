package com.myProject.mapper;

import com.myProject.config.H_Role;
import com.myProject.dto.H_USERS_Dto;
import com.myProject.model.H_POSTS;
import com.myProject.model.H_USERS;
import com.myProject.repositories.H_POSTS_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class H_USERS_Mapper {

    @Autowired
    H_POSTS_Repo h_posts_repo;

    public H_USERS_Dto map_H_USERS_to_H_USERS_Dto(H_USERS h_users){
        H_USERS_Dto h_users_dto = new H_USERS_Dto();

        h_users_dto.setID(h_users.getID());
        h_users_dto.setLOGG(h_users.getLOGG());
        h_users_dto.setPASS(h_users.getPASS());
        for (H_POSTS posts : h_posts_repo.findAll())
            if(1 == h_users.getID_POST()) h_users_dto.setID_POST(H_Role.MAG.getValue());
        else if (2 == h_users.getID_POST()) h_users_dto.setID_POST(H_Role.MEH.getValue());
        else if (3 == h_users.getID_POST()) h_users_dto.setID_POST(H_Role.DIS.getValue());
        else if (4 == h_users.getID_POST()) h_users_dto.setID_POST(H_Role.BIS.getValue());
            //h_users_dto.setID_POST(h_users.getID_POST());
        h_users_dto.setNAME_FIRST(h_users.getNAME_LAST());
        h_users_dto.setNAME_LAST(h_users.getNAME_LAST());
        h_users_dto.setPHONENUM(h_users.getPHONENUM());
        h_users_dto.setSTAT(h_users.isSTAT());

        return h_users_dto;
    }

}
