package com.bitbyte.cargaraage.controller;

import com.bitbyte.cargaraage.enitities.UserEntity;
import com.bitbyte.cargaraage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@CrossOrigin
public class UsersController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity<Iterable<UserEntity>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable String id){
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("users/validate_credentials")
    public ResponseEntity<Boolean> checkPassword(@RequestParam String emailAddress, @RequestBody String password) throws NoSuchAlgorithmException {
        return new ResponseEntity<>(service.checkPassword(password, emailAddress), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user){
        return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable String id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
