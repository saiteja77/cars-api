package com.bitbyte.cargaraage.controller;

import com.bitbyte.cargaraage.enitities.CarsEntity;
import com.bitbyte.cargaraage.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CarsController {

    @Autowired
    private CarsService service;

    @GetMapping("/cars")
    public ResponseEntity<Iterable<CarsEntity>> getCars(){
        return new ResponseEntity<>(service.getCars(), HttpStatus.OK);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<CarsEntity> getCarsById(@PathVariable String id){
        return new ResponseEntity<>(service.getCarsById(id), HttpStatus.OK);
    }

    @PostMapping("/cars")
    public ResponseEntity<CarsEntity> saveCar(@RequestBody CarsEntity car){
        return new ResponseEntity<>(service.saveCar(car), HttpStatus.CREATED);
    }
}
