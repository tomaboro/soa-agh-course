package Model;

import javax.persistence.*;

@Entity
@Table(name="zawodnik")
public class Zawodnik {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    String imie;
    String nazwisko;
    int punkty;
    String narodowosc;

    public Zawodnik() {}

    public Zawodnik(String imie, String nazwisko, int punkty, String narodowosc) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.punkty = punkty;
        this.narodowosc = narodowosc;
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

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getPunkty() {
        return punkty;
    }

    public void setPunkty(int punkty) {
        this.punkty = punkty;
    }

    public String getNarodowosc() {
        return narodowosc;
    }

    public void setNarodowosc(String narodowosc) {
        this.narodowosc = narodowosc;
    }
}
