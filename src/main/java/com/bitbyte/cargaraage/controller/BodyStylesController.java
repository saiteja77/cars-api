package com.bitbyte.cargaraage.controller;

import com.bitbyte.cargaraage.enitities.BodyStylesEntity;
import com.bitbyte.cargaraage.service.BodyStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@CrossOrigin
public class BodyStylesController {

    @Autowired
    private BodyStyleService service;

    @GetMapping("/bodyStyles")
    public ResponseEntity<Iterable<BodyStylesEntity>> getBodyStyles() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/bodyStyles/{id}")
    public ResponseEntity<BodyStylesEntity> getBodyStyles(@NotNull @PathVariable String id) {
        BodyStylesEntity make = service.getById(id);
        if (make != null)
            return new ResponseEntity<>(make, HttpStatus.OK);
        else
            return new ResponseEntity<>(new BodyStylesEntity(null), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/bodyStyles")
    public ResponseEntity<BodyStylesEntity> saveBodyStyles(@NotNull @RequestBody BodyStylesEntity make) {
        BodyStylesEntity makesEntity = service.save(make);
        return new ResponseEntity<>(makesEntity, HttpStatus.CREATED);
    }

    @PutMapping("/bodyStyles")
    public ResponseEntity<BodyStylesEntity> updateBodyStyles(@NotNull @RequestBody BodyStylesEntity make, @NotNull @PathVariable String id) {
        BodyStylesEntity makesEntity = service.update(make, id);
        if (makesEntity != null)
            return new ResponseEntity<>(makesEntity, HttpStatus.OK);
        else
            return new ResponseEntity<>(make, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/bodyStyles")
    public ResponseEntity<BodyStylesEntity> deleteBodyStyles(@NotNull @PathVariable String id) {
        Optional<BodyStylesEntity> make = service.delete(id);
        if (make.isPresent())
            return new ResponseEntity<>(make.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(new BodyStylesEntity(null), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/bodyStyles/pageable")
    public ResponseEntity<Page<BodyStylesEntity>> getPageableBodyStyles(@NotNull @RequestParam Integer pageNumber, @NotNull @RequestParam Integer pageSize) {
        return new ResponseEntity<>(service.getPageableBodyStyles(pageNumber, pageSize), HttpStatus.OK);
    }
}
