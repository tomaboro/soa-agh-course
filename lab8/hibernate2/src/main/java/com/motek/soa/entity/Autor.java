package com.motek.soa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Autor {
    private int id;

    @Override
    public String toString() {
        StringBuilder dziela = new StringBuilder();
        for(Ksiazka k: this.dziela){
            dziela.append(" {" + k.getTytul() + "} ").append(" ");
        }
        return "Autor{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", narodowosc='" + narodowosc + '\'' +
                ", dziela=" + dziela +
                '}';
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String imie;

    @Basic
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    private String nazwisko;

    @Basic
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    private String narodowosc;

    @Basic
    public String getNarodowosc() {
        return narodowosc;
    }

    public void setNarodowosc(String narodowosc) {
        this.narodowosc = narodowosc;
    }

    private List<Ksiazka> dziela = new LinkedList<Ksiazka>();

    @OneToMany(mappedBy = "autor")
    public List<Ksiazka> getDziela() {
        return dziela;
    }

    public void setDziela(List<Ksiazka> dziela) {
        this.dziela = dziela;
    }

    public void addDzielo(Ksiazka ksiazka) {
        if(dziela == null){
            dziela = new ArrayList<Ksiazka>();
        }
        dziela.add(ksiazka);
    }
}
