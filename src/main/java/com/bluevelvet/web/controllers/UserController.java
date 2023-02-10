package com.bluevelvet.web.controllers;

import com.bluevelvet.web.entities.User;
import com.bluevelvet.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(name = "/users")
public class UserController {

    @Autowired
    UserService userService;

    /*---------------------------LISTA TODOS USUÁRIOS--------------------------*/
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
    /*---------------------------INSERE USUÁRIO--------------------------*/
    @PostMapping(path = "/users")
    public ResponseEntity<User> insert(@RequestBody User user){
        userService.insert(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    /*---------------------------DELETA USUARIO POR ID--------------------------*/
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        User u = userService.findById(id);
        userService.delete(u.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /*---------------------------EDITA USUARIO POR ID--------------------------*/
    @PutMapping(path = "/replace/{id}")
    public ResponseEntity<User> replace(@PathVariable Long id, @RequestBody User user){
        user = userService.replace(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
