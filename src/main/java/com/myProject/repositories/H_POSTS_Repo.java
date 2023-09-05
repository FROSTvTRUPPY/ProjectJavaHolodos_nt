package com.myProject.repositories;

import com.myProject.model.H_POSTS;
import com.myProject.model.H_USERS;
import org.springframework.data.repository.CrudRepository;

public interface H_POSTS_Repo extends CrudRepository<H_POSTS, Integer> {
}
