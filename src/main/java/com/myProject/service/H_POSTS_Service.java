package com.myProject.service;

import com.myProject.mapper.H_POSTS_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class H_POSTS_Service {

    @Autowired
    H_POSTS_Mapper h_posts_mapper;

}
