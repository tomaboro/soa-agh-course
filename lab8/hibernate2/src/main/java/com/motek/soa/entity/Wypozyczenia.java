package com.motek.soa.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Wypozyczenia {
    private int id;

    @Override
    public String toString() {
        return "Wypozyczenia{" +
                "id=" + id +
                ", dataWypozyczenia=" + dataWypozyczenia +
                ", dataZwrotu=" + dataZwrotu +
                ", ksiazka=" + ksiazka +
                ", wypozyczajacy=" + wypozyczajacy +
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

    private Date dataWypozyczenia;

    @Basic
    public Date getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    public void setDataWypozyczenia(Date wypozyczenie) {
        this.dataWypozyczenia = wypozyczenie;
    }

    @Temporal(TemporalType.DATE)
    private Date dataZwrotu;

    @Basic
    public Date getDataZwrotu() {
        return dataZwrotu;
    }

    public void setDataZwrotu(Date zwrot) {
        this.dataZwrotu = zwrot;
    }

    private Ksiazka ksiazka;

    @OneToOne(cascade = CascadeType.ALL)
    public Ksiazka getKsiazka() {
        return ksiazka;
    }

    public void setKsiazka(Ksiazka ksiazka) {
        this.ksiazka = ksiazka;
    }

    private Czytelnik wypozyczajacy;

    @ManyToOne
    public Czytelnik getWypozyczajacy() {
        return wypozyczajacy;
    }

    public void setWypozyczajacy(Czytelnik wypozyczajacy) {
        this.wypozyczajacy = wypozyczajacy;
    }
}
