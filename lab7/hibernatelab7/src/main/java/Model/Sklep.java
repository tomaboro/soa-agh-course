package Model;

import Model.SklepId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sklep")
public class Sklep {
    @EmbeddedId
    private SklepId id;
    private double cena;

    public Sklep(){}

    public Sklep(int artykul, String dostawca, double cena) {
        this.id = new SklepId(artykul,dostawca);
        this.cena = cena;
    }

    public SklepId getId() {
        return id;
    }

    public void setId(SklepId id) {
        this.id = id;
    }



    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
