package Model;

import javax.persistence.*;

@Entity
@Table(name = "pies")
public class Pies {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String imie;
    private String rasa;
    private int wiek;

    public Pies() {}

    public Pies(String imie, String rasa, int wiek) {
        this.imie = imie;
        this.rasa = rasa;
        this.wiek = wiek;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }
}
