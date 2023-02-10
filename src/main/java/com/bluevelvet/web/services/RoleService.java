package com.bluevelvet.web.services;

import com.bluevelvet.web.entities.Role;
import com.bluevelvet.web.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public Role insert(Role role){
        boolean exist = roleRepository.existsByRoleName(role.getRoleName());
        if(!exist) {
            return roleRepository.save(role);
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Role ja cadastrado");
        }
}

