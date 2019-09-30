package com.bitbyte.cargaraage.enitities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
public class CarsEntity {

    @Id
    private String id;
    private String carName;
    private Properties specs;

    public CarsEntity() {
    }

    public CarsEntity(String carName, Properties specs) {
        this.carName = carName;
        this.specs = specs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Properties getSpecs() {
        return specs;
    }

    public void setSpecs(Properties specs) {
        this.specs = specs;
    }
}
