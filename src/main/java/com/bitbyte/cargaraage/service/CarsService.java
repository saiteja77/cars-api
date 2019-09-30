package com.bitbyte.cargaraage.service;

import com.bitbyte.cargaraage.enitities.CarsEntity;
import com.bitbyte.cargaraage.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CarsService {

    @Autowired
    private CarsRepository repository;

    public Iterable<CarsEntity> getCars() {
        return repository.findAll();
    }

    public CarsEntity getCarsById(String id) {
        repository.findById(id);
        return new CarsEntity();
    }

    public CarsEntity saveCar(CarsEntity car) {
        return repository.save(car);
    }
}
