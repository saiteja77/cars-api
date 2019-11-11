package com.bitbyte.cargaraage.service;

import com.bitbyte.cargaraage.enitities.BodyStylesEntity;
import com.bitbyte.cargaraage.enitities.CarsEntity;
import com.bitbyte.cargaraage.enitities.MakesEntity;
import com.bitbyte.cargaraage.repository.BodyStylesRepository;
import com.bitbyte.cargaraage.repository.CarsRepository;
import com.bitbyte.cargaraage.repository.MakesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarsService {

    @Autowired
    private CarsRepository repository;

    @Autowired
    private BodyStylesRepository bodyStylesRepository;

    @Autowired
    private MakesRepository makesRepository;

    public Iterable<CarsEntity> getCars() {
        return repository.findAll();
    }

    public CarsEntity getCarsById(String id) {
        Optional<CarsEntity> car = repository.findById(id);
        return car.isPresent() ? car.get() : null;
    }

    public CarsEntity saveCar(CarsEntity car) {
        Optional<BodyStylesEntity> bodyStyle = bodyStylesRepository.findByStyleName(car.getSpecs().getBodyStyle().getStyleName());
        Optional<MakesEntity> make = makesRepository.findByMakeName(car.getSpecs().getMake().getMakeName());
        if(bodyStyle.isPresent() && make.isPresent()){
            car.getSpecs().getBodyStyle().setId(bodyStyle.get().getId());
            car.getSpecs().getMake().setId(make.get().getId());
        } else if(bodyStyle.isPresent() || make.isPresent()){
            if(bodyStyle.isPresent())
                car.getSpecs().getBodyStyle().setId(bodyStyle.get().getId());
            else
                car.getSpecs().getMake().setId(make.get().getId());
        }
        return repository.save(car);
    }

    public CarsEntity updateCar(CarsEntity car) {
        return repository.save(car);
    }
}
