package com.bitbyte.cargaraage.controller;

import com.bitbyte.cargaraage.enitities.CarsEntity;
import com.bitbyte.cargaraage.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        CarsEntity car = service.getCarsById(id);
        if( car != null)
            return new ResponseEntity<>(car, HttpStatus.OK);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/cars")
    public ResponseEntity<CarsEntity> saveCar(@RequestBody CarsEntity car){
        return new ResponseEntity<>(service.saveCar(car), HttpStatus.CREATED);
    }

    @PutMapping("/cars")
    public ResponseEntity<CarsEntity> updateCar(@RequestBody CarsEntity car) {
        return  new ResponseEntity<>(service.updateCar(car), HttpStatus.OK);
    }
}
