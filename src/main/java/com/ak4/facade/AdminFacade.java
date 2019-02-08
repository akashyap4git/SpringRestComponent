package com.ak4.facade;

import com.ak4.exception.AppWebApplicationException;
import com.ak4.exception.UserAlreadyExistException;
import com.ak4.schema.UserAndRole;
import com.ak4.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AdminFacade {

    @Autowired
    private AdminService adminService;

    public boolean addUserAndRole(UserAndRole userAndRole) throws AppWebApplicationException, UserAlreadyExistException {
        return adminService.addUserAndRole(userAndRole);
    }
}
