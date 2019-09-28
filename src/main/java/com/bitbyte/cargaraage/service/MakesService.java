package com.bitbyte.cargaraage.service;

import com.bitbyte.cargaraage.enitities.MakesEntity;
import com.bitbyte.cargaraage.repository.MakesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class MakesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MakesService.class);

    @Autowired
    private MakesRepository repository;

    public Iterable<MakesEntity> getAll() {
        return repository.findAll();
    }

    public MakesEntity getById(@NotNull String id){
        Optional<MakesEntity> make = repository.findById(id);
        if(make.isPresent()) {
            LOGGER.info("Found One Make");
            return make.get();
        }
        else{
            LOGGER.error("No makes were found for the given ID: {}", id);
            return null;
        }
    }

    public MakesEntity save(@NotNull MakesEntity make) {
        MakesEntity newEntity = repository.save(new MakesEntity(make.getMakeName()));
        return newEntity;
    }

    public MakesEntity update(@NotNull MakesEntity make, @NotNull String id) {
        Optional<MakesEntity> entity = repository.findById(id);
        if(entity.isPresent()){
            entity.get().setMakeName(make.getMakeName());
            return repository.save(entity.get());
        } else
            return null;
    }

    public Optional<MakesEntity> delete(String id) {
        Optional<MakesEntity> entity = repository.findById(id);
        if(entity.isPresent())
            repository.delete(entity.get());
        return entity;
    }
}
