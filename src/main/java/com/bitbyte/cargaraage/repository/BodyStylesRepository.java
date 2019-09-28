package com.bitbyte.cargaraage.repository;

import com.bitbyte.cargaraage.enitities.BodyStylesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyStylesRepository extends CrudRepository<BodyStylesEntity, String> {

}
