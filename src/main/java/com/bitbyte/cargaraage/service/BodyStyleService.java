package com.bitbyte.cargaraage.service;

import com.bitbyte.cargaraage.enitities.BodyStylesEntity;
import com.bitbyte.cargaraage.repository.BodyStylesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

import static org.springframework.data.domain.PageRequest.*;

@Service
public class BodyStyleService {

    @Autowired
    private BodyStylesRepository repository;

    public Iterable<BodyStylesEntity> getAll() {
        return repository.findAll();
    }

    public BodyStylesEntity getById(@NotNull String id){
        Optional<BodyStylesEntity> make = repository.findById(id);
        if(make.isPresent()) {
            return make.get();
        }
        else{
            return null;
        }
    }

    public BodyStylesEntity save(@NotNull BodyStylesEntity make) {
        BodyStylesEntity newEntity = repository.save(new BodyStylesEntity(make.getStyleName()));
        return newEntity;
    }

    public BodyStylesEntity update(@NotNull BodyStylesEntity bodyStyle, @NotNull String id) {
        Optional<BodyStylesEntity> entity = repository.findById(id);
        if(entity.isPresent()){
            entity.get().setStyleName(bodyStyle.getStyleName());
            return repository.save(entity.get());
        } else
            return null;
    }

    public Optional<BodyStylesEntity> delete(String id) {
        Optional<BodyStylesEntity> entity = repository.findById(id);
        if(entity.isPresent())
            repository.delete(entity.get());
        return entity;
    }

    public Page<BodyStylesEntity> getPageableBodyStyles(int pageNumber, int pageSize){
        return repository.findAll(of(pageNumber,pageSize));
    }
}
