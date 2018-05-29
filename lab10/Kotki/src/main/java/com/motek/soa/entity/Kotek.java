package com.motek.soa.entity;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.persistence.*;

@Entity
public class Kotek {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Basic
    private String imie;

    @Basic
    private Character plec;

    @Basic
    private String rasa;

    @Basic
    private String wlasciciel;

    @Basic
    private Integer wiek;

    public Character getPlec() {
        return plec;
    }

    public void setPlec(Character plec) {
        this.plec = plec;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public Integer getWiek() {
        return wiek;
    }

    public void setWiek(Integer wiek) {
        this.wiek = wiek;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String name) {
        this.imie = name;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public static Kotek parseJson(String json) {
        JsonElement kotekJsonElement = new JsonParser().parse(json);
        return parseJson(kotekJsonElement);
    }

    public static Kotek parseJson(JsonElement kotekJsonElement) {
        JsonObject kotekJsonObject = kotekJsonElement.getAsJsonObject();
        Kotek kotek = new Kotek();
        kotek.setImie(kotekJsonObject.get("imie").getAsString());
        kotek.setWiek(kotekJsonObject.get("wiek").getAsInt());
        kotek.setPlec(kotekJsonObject.get("plec").getAsCharacter());
        kotek.setRasa(kotekJsonObject.get("rasa").getAsString());
        kotek.setWlasciciel(kotekJsonObject.get("wlasciciel").getAsString());
        return kotek;
    }
}
