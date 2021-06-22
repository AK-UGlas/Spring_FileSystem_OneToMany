package com.codeclan.folder_service.controllers;

import com.codeclan.folder_service.models.User;
import com.codeclan.folder_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        return new ResponseEntity<>(userRepo.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/files")
    public ResponseEntity<User> postUser(@RequestBody User user) {
        return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
    }
}
