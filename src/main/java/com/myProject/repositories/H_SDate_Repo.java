package com.myProject.repositories;

import com.myProject.model.H_POSTS;
import com.myProject.model.H_SData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface H_SDate_Repo extends CrudRepository<H_SData, Integer> {
    List<H_SData> findAllByCONTROLLERIDOrderByID(int CONTROLLERID);
}
