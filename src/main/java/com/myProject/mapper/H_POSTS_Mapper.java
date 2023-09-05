package com.myProject.mapper;

import com.myProject.dto.H_POSTS_Dto;
import com.myProject.model.H_POSTS;
import com.myProject.repositories.H_POSTS_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class H_POSTS_Mapper {

public H_POSTS_Dto map_H_POSTS_to_H_POSTS_Dto(H_POSTS h_posts){
    H_POSTS_Dto h_posts_dto = new H_POSTS_Dto();
    h_posts_dto.setID(h_posts.getID());
    h_posts_dto.setNAME(h_posts.getNAME());
    h_posts_dto.setDESC(h_posts.getDESC());

    return h_posts_dto;
}

}
