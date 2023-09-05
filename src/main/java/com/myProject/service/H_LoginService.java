package com.myProject.service;

import com.myProject.config.H_Role;
import com.myProject.dto.H_KeyAuth;
import com.myProject.model.H_USERS;
import com.myProject.repositories.H_USERS_Repo;
import com.myProject.sessionData.H_DtAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class H_LoginService {

    @Autowired
    H_USERS_Repo h_users_repo;

    public boolean login(H_KeyAuth keyAuth){

        for(H_USERS user: h_users_repo.findAll()){
            if(user.getID() == keyAuth.getID()){
                H_DtAuth.get(false).setAttribute("SessionRole", user.getID_POST());
                H_DtAuth.get(false).setAttribute("SessionUserID", user.getID());
                return true;
            }
        }
        return false;
    }


    public void logout(){
        H_DtAuth.get(false).removeAttribute("SessionIsActiv");
        H_DtAuth.get(false).removeAttribute("SessionRole");
        H_DtAuth.get(false).removeAttribute("SessionUserID");
    }

    /*public String getPassport(){
        return  DataAuthorization.get(false).getAttribute("SessionUser").toString();
    }*/
    public H_Role getRole(){

        if(Integer.toString(1).equals(H_DtAuth.get(false).getAttribute("SessionRole").toString())) return H_Role.MAG;
        else if(Integer.toString(2).equals(H_DtAuth.get(false).getAttribute("SessionRole").toString())) return H_Role.MEH;
        else if(Integer.toString(3).equals(H_DtAuth.get(false).getAttribute("SessionRole").toString())) return H_Role.DIS;
        else if(Integer.toString(4).equals(H_DtAuth.get(false).getAttribute("SessionRole").toString())) return H_Role.BIS;

        return  null;
    }
    public int getId(){
        return  (int)H_DtAuth.get(false).getAttribute("SessionUserID");
    }

}
