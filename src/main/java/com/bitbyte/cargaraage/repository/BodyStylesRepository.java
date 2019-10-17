package com.bitbyte.cargaraage.repository;

import com.bitbyte.cargaraage.enitities.BodyStylesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyStylesRepository extends CrudRepository<BodyStylesEntity, String> {

    Page<BodyStylesEntity> findAll(Pageable page);

}
