package com.myProject.service;

import com.myProject.config.H_Role;
import com.myProject.dto.H_KeyAuth;
import com.myProject.model.H_USERS;
import com.myProject.repositories.H_USERS_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class H_AuthService {

    @Autowired
    private H_USERS_Repo repo;

    public H_KeyAuth login(String login, String password){

        for(H_USERS accountTmp: repo.findAll()){
            if(accountTmp.getLOGG().equals(login) && accountTmp.getPASS().equals(password)){
                H_KeyAuth key = new H_KeyAuth();
                key.setID(accountTmp.getID());
                return key;
            }
        }
        return null;
    }

    public H_Role login_r(String login, String password){

        for(H_USERS accountTmp: repo.findAll()){
            if(accountTmp.getLOGG().equals(login) && accountTmp.getPASS().equals(password)){
              if (accountTmp.getID_POST() == 1)
                return H_Role.MAG;
              else if (accountTmp.getID_POST() == 2)
                  return H_Role.MEH;
              else if (accountTmp.getID_POST() == 3)
                  return H_Role.DIS;
              else if (accountTmp.getID_POST() == 4)
                  return H_Role.BIS;
            }
        }
        return null;
    }

    public H_USERS login_datas(int ID){

        for(H_USERS accountTmp: repo.findAll()){
            if(accountTmp.getID() == ID){
                return accountTmp;
            }
        }
        return null;
    }

}
