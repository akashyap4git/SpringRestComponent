package com.ak4.mapper;

import com.ak4.entity.admin.RoleEntity;
import com.ak4.entity.admin.UserEntity;
import com.ak4.schema.UserAndRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class AdminMapper {

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public UserEntity from(UserAndRole userAndRole) {
        UserEntity userEntity = new UserEntity();

        Set<RoleEntity> rolesEntities = new HashSet<>();
        for(String roles : userAndRole.getRoles()) {
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setRole(roles);
            rolesEntities.add(roleEntity);
        }
        userEntity.setUsername(userAndRole.getUsername());
        userEntity.setPassword(bCryptPasswordEncoder.encode(userAndRole.getPassword()));
        userEntity.setActive(1);
        userEntity.setRoles(rolesEntities);
        return userEntity;
    }
}
