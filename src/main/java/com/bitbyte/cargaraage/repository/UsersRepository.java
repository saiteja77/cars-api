package com.bitbyte.cargaraage.repository;

import com.bitbyte.cargaraage.enitities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<UserEntity, String> {
    Optional<UserEntity> findByEmailAddress(String emailAddress);
}
