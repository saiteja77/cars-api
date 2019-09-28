package com.bitbyte.cargaraage.enitities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "body_styles")
public class BodyStylesEntity {

    @Id
    private String id;

    @JsonProperty(value = "value")
    private String styleName;

    public BodyStylesEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public BodyStylesEntity(String styleName) {
        this.styleName = styleName;
    }
}
