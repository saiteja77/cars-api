package com.bitbyte.cargaraage.repository;

import com.bitbyte.cargaraage.enitities.CarsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends CrudRepository<CarsEntity, String> {
}
