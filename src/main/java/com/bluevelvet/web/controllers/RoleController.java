package com.bluevelvet.web.controllers;

import com.bluevelvet.web.entities.Role;
import com.bluevelvet.web.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    /*---------------------------INSERE ROLE--------------------------*/
    @PostMapping
    public ResponseEntity<Role> insert(@RequestBody Role role){
        roleService.insert(role);
        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }
}
