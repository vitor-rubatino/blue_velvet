package com.bluevelvet.web.services;

import com.bluevelvet.web.entities.User;
import com.bluevelvet.web.repositories.RoleRepository;
import com.bluevelvet.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    /*---------------------------LISTA TODOS USUÁRIOS--------------------------*/
    public List<User> findAll(){
        return userRepository.findAll();
    }

    /*---------------------------BUSCA USUÁRIO POR ID--------------------------*/
    public User findById(Long id) {
        User u;
        boolean exist = userRepository.existsById(id);
        if(exist) {
            u = userRepository.findById(id).get();
            return u;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não encontrado");
        }
    }

    public User findByIdOrThrowNotFound(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    /*---------------------------INSERE USUÁRIO--------------------------*/
    public User insert(User user){
        boolean exist = userRepository.existsByUsername(user.getUsername());
        if(!exist) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            user.setRoles(Arrays.asList(roleRepository.findById(2L).get()));
            return userRepository.save(user);
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username ja cadastrado");
    }
    /*---------------------------EDITA USUÁRIO--------------------------*/
    public User replace(Long id, User user) {
        try {
            User u = userRepository.getReferenceById(id);
            updateData(u, user);
            return userRepository.save(u);
        }catch(ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
    }
    private void updateData(User u, User us) {
        u.setFirstName(us.getFirstName());
        u.setLastName(us.getLastName());
        u.setPassword(new BCryptPasswordEncoder().encode(us.getPassword()));
        u.setRoles(us.getRoles());
        u.setPhotos(us.getPhotos());
        u.isEnabled();
    }

    /*---------------------------EDITA USUÁRIO--------------------------*/
    public void delete(Long id) {
        userRepository.delete(findByIdOrThrowNotFound(id));
    }
}
