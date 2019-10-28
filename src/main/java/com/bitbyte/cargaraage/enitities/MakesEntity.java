package com.bitbyte.cargaraage.enitities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "makes")
public class MakesEntity {

    @Id
    private String id;

    @Indexed(direction = IndexDirection.ASCENDING)
    @JsonProperty(value = "value")
    private String makeName;

    public MakesEntity(String makeName) {
        this.makeName = makeName;
    }

    public String getId() {
        return id;
    }

    public String getMakeName() {
        return makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MakesEntity() {
    }
}
