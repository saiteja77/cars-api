package com.bitbyte.cargaraage.controller;

import com.bitbyte.cargaraage.enitities.MakesEntity;
import com.bitbyte.cargaraage.service.MakesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@CrossOrigin
public class MakesController {

    @Autowired
    private MakesService service;

    @GetMapping("/makes")
    public ResponseEntity<Iterable<MakesEntity>> getMakes(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/makes/{id}")
    public ResponseEntity<MakesEntity> getMakesEntity(@NotNull @PathVariable String id){
        MakesEntity make = service.getById(id);
        if(make!=null)
            return new ResponseEntity<>(make, HttpStatus.OK);
        else
            return new ResponseEntity<>(new MakesEntity(null), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/makes")
    public ResponseEntity<MakesEntity> saveMakes(@NotNull @RequestBody MakesEntity make){
        MakesEntity makesEntity = service.save(make);
        return new ResponseEntity<>(makesEntity, HttpStatus.CREATED);
    }

    @PutMapping("/makes")
    public ResponseEntity<MakesEntity> updateMakes(@NotNull @RequestBody MakesEntity make, @NotNull @PathVariable String id){
        MakesEntity makesEntity = service.update(make, id);
        if (makesEntity != null)
            return new ResponseEntity<>(makesEntity, HttpStatus.OK);
        else
            return new ResponseEntity<>(make, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/makes")
    public ResponseEntity<MakesEntity> deleteMakes(@NotNull @PathVariable String id){
        Optional<MakesEntity> make = service.delete(id);
        if(make.isPresent())
            return new ResponseEntity<>(make.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(new MakesEntity(null), HttpStatus.BAD_REQUEST);
    }
}
