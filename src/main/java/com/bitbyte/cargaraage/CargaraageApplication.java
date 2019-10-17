package com.bitbyte.cargaraage;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Configuration
@EnableEncryptableProperties
public class CargaraageApplication {

    private final Logger LOGGER = LoggerFactory.getLogger(CargaraageApplication.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Bean
    public void run() throws Exception {
        LOGGER.info("Successfully connected to the database: {}", mongoTemplate.getDb().getName());

    }

    public static void main(String[] args) {
        SpringApplication.run(CargaraageApplication.class, args);
    }

}
