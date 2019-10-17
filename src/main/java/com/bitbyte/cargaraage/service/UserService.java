package com.bitbyte.cargaraage.service;

import com.bitbyte.cargaraage.enitities.UserEntity;
import com.bitbyte.cargaraage.pojo.Status;
import com.bitbyte.cargaraage.repository.UsersRepository;
import com.bitbyte.cargaraage.utils.PasswordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Value("${password.hashing-algorithm}")
    private String hashingAlgorithm;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UsersRepository repository;

    public UserEntity getUserById(String id) {
        return repository.findById(id).get();
    }

    public UserEntity save(UserEntity user) {
        byte[] salt = PasswordUtils.createSalt();
        UserEntity newUser = new UserEntity();
        user.setHashingAlgorithm(hashingAlgorithm);
        try {
            byte[] passwordHash = PasswordUtils.generateSaltedHash(user.getPassword(), hashingAlgorithm, salt);
            String password = PasswordUtils.convertByteArrayToHexString(passwordHash);
            user.setPassword(password);
            user.setSalt(salt);
            user.setStatus(Status.ACTIVE);
            newUser = repository.save(user);
            newUser.setPassword(null);
            return newUser;
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error(e.getMessage());
            return newUser;
        }
    }

    public Boolean checkPassword(String password, String emailAddress) throws NoSuchAlgorithmException {
        Optional<UserEntity> user = repository.findByEmailAddress(emailAddress);
        if (user.isPresent()) {
            return PasswordUtils.comparePasswords(password, user.get().getPassword(), user.get().getSalt(), user.get().getHashingAlgorithm());
        } else
            return false;

    }

    public UserEntity delete(String id) {
        Optional<UserEntity> user = repository.findById(id);
        if(user.isPresent()) {
            UserEntity userToBeDeleted = user.get();
            userToBeDeleted.setStatus(Status.DELETED);
            return repository.save(userToBeDeleted);
        } else
            return new UserEntity();
    }

    public Iterable<UserEntity> getAll() {
        return repository.findAll();
    }
}
