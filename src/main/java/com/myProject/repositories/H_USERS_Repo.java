package com.myProject.repositories;

import com.myProject.model.H_USERS;
import org.springframework.data.repository.CrudRepository;

public interface H_USERS_Repo extends CrudRepository<H_USERS, Integer> {
    H_USERS findByID(int ID);
}
