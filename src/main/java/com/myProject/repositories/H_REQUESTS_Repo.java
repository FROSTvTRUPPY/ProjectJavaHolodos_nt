package com.myProject.repositories;

import com.myProject.model.H_REQUESTS;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface H_REQUESTS_Repo extends CrudRepository<H_REQUESTS, Integer> {
    H_REQUESTS findByID(int ID);
    List<H_REQUESTS> findAllByIDMAGAndSTATUS(int IDMAG, String STATUS);
    List<H_REQUESTS> findAllByIDMEHAndSTATUS(int IDMEH, String STATUS);
    List<H_REQUESTS> findAllByIDMEHOrderBySTATUS(int IDMEH);
    List<H_REQUESTS> findAllByIDMAGOrderBySTATUS(int IDMAG);
}
