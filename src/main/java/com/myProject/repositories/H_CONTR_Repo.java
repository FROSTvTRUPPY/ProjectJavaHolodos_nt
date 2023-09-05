package com.myProject.repositories;

import com.myProject.model.H_CONTR;
import com.myProject.model.H_USERS;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface H_CONTR_Repo extends CrudRepository<H_CONTR, Integer> {

    List<H_CONTR> findAllByMAGIDOrderByID(int MAGID);

}
