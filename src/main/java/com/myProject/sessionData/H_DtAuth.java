package com.myProject.sessionData;

import com.myProject.config.H_Role;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class H_DtAuth {


    public static HttpSession get(boolean isNew) {
        ServletRequestAttributes att = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = att.getRequest().getSession(isNew);
        return session;
    }

    private static String userPass;
    private static H_Role role;
    private static int userID;


    public static String getUserPass() {
        return userPass;
    }

    public static void setUserPass(String userPass) {
        H_DtAuth.userPass = userPass;
    }

    public static H_Role getRole() {
        return role;
    }

    public static void setRole(H_Role role) {
        H_DtAuth.role = role;
    }

    public static int getUserID() {
        return userID;
    }

    public static void setUserID(int userID) {
        H_DtAuth.userID = userID;
    }
}

