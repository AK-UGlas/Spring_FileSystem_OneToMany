package com.codeclan.folder_service.controllers;

import com.codeclan.folder_service.models.File;
import com.codeclan.folder_service.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepo;

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllFiles(){
        return new ResponseEntity<>(fileRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity getPirate(@PathVariable Long id){
        return new ResponseEntity<>(fileRepo.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> postPirate(@RequestBody File file) {
        return new ResponseEntity<>(fileRepo.save(file), HttpStatus.CREATED);
    }

}
