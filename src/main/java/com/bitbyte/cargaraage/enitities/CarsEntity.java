package com.bitbyte.cargaraage.enitities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cars")
public class CarsEntity {

    @Id
    private String id;
    private String carName;
    private Integer carPrice;
    private Properties specs;
    private List<String> pictures;

    public CarsEntity() {
    }

    public CarsEntity(String carName, Integer carPrice, Properties specs, List<String> pictures) {
        this.carName = carName;
        this.carPrice = carPrice;
        this.specs = specs;
        this.pictures = pictures;
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

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public Integer getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Integer carPrice) {
        this.carPrice = carPrice;
    }
}
