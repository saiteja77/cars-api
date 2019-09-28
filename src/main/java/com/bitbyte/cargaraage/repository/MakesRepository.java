package com.bitbyte.cargaraage.repository;

import com.bitbyte.cargaraage.enitities.MakesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakesRepository extends CrudRepository<MakesEntity, String> {
}
