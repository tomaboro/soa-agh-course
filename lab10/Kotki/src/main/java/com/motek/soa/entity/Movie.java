package com.motek.soa.entity;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.motek.soa.UUIDGenerator;
import com.motek.soa.rest.MoviesEndpoint;

import javax.persistence.*;

@Entity
public class Movie {

    @Id
    private Integer id;

    @Basic
    private String title;

    @Basic
    private String uri;

    @Basic
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId() {
        this.id = UUIDGenerator.getInstance().getId();
        this.uri = MoviesEndpoint.endpointUri + "/" + id;
    }

    public void setId(Integer id){
        this.id = id;
        this.uri = MoviesEndpoint.endpointUri + "/" + id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public static Movie parseJson(String json) {
        JsonElement kotekJsonElement = new JsonParser().parse(json);
        return parseJson(kotekJsonElement);
    }

    public static Movie parseJson(JsonElement movieJsonElement) {
        JsonObject movieJsonObject = movieJsonElement.getAsJsonObject();
        Movie movie = new Movie();
        movie.setId();
        movie.setTitle(movieJsonObject.get("title").getAsString());
        movie.setDescription(movieJsonObject.get("description").getAsString());
        return movie;
    }

    public static Movie parseJsonWithoutId(String json) {
        JsonElement kotekJsonElement = new JsonParser().parse(json);
        return parseJsonWithoutId(kotekJsonElement);
    }

    public static Movie parseJsonWithoutId(JsonElement movieJsonElement) {
        JsonObject movieJsonObject = movieJsonElement.getAsJsonObject();
        Movie movie = new Movie();
        movie.setTitle(movieJsonObject.get("title").getAsString());
        movie.setDescription(movieJsonObject.get("description").getAsString());
        return movie;
    }
}
