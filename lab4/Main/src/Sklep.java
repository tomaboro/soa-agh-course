import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;

@ManagedBean()
@SessionScoped()
public class Sklep {
    //Podstawowe
    private String imie;
    private String mail;
    private int wiek;
    private String plec ="m";
    private String wyksztalcenie;
    private int wzrost;

    //Kobiety
    private int biust;
    private int miseczka;
    private int talia;
    private int biodra;
    //Wspolne
    private int nogi;
    //Meszczyzni
    private int klatka;
    private int pas;

    //Pytania
    private String q1;
    private String q2;
    private String q3;
    private String[] q4;
    private String q5;
    private String q6;
    private String q7;
    private String q8;

    private String[] q4ans_female = {"garsonki","bluzki","spódniczki","spodnie"};
    private String[] q4ans_male = {"spodnie","spodenki","garnitury","koszule","krawaty"};

    public String getNiceQ4() {
        return Arrays.toString(q4);
    }

    public String[] getQ4ans_female() {
        return q4ans_female;
    }

    public void setQ4ans_female(String[] q4ans_female) {
        this.q4ans_female = q4ans_female;
    }

    public String[] getQ4ans_male() {
        return q4ans_male;
    }

    public void setQ4ans_male(String[] q4ans_male) {
        this.q4ans_male = q4ans_male;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getWyksztalcenie() {
        return wyksztalcenie;
    }

    public void setWyksztalcenie(String wyksztalcenie) {
        this.wyksztalcenie = wyksztalcenie;
    }

    public int getWzrost() {
        return wzrost;
    }

    public void setWzrost(int wzrost) {
        this.wzrost = wzrost;
    }

    public int getBiust() {
        return biust;
    }

    public void setBiust(int biust) {
        this.biust = biust;
    }

    public int getMiseczka() {
        return miseczka;
    }

    public void setMiseczka(int miseczka) {
        this.miseczka = miseczka;
    }

    public int getTalia() {
        return talia;
    }

    public void setTalia(int talia) {
        this.talia = talia;
    }

    public int getBiodra() {
        return biodra;
    }

    public void setBiodra(int biodra) {
        this.biodra = biodra;
    }

    public int getNogi() {
        return nogi;
    }

    public void setNogi(int nogi) {
        this.nogi = nogi;
    }

    public int getKlatka() {
        return klatka;
    }

    public void setKlatka(int klatka) {
        this.klatka = klatka;
    }

    public int getPas() {
        return pas;
    }

    public void setPas(int pas) {
        this.pas = pas;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String[] getQ4() {
        return q4;
    }

    public void setQ4(String[] q4) {
        this.q4 = q4;
    }

    public String getQ5() {
        return q5;
    }

    public void setQ5(String q5) {
        this.q5 = q5;
    }

    public String getQ6() {
        return q6;
    }

    public void setQ6(String q6) {
        this.q6 = q6;
    }

    public String getQ7() {
        return q7;
    }

    public void setQ7(String q7) {
        this.q7 = q7;
    }

    public String getQ8() {
        return q8;
    }

    public void setQ8(String q8) {
        this.q8 = q8;
    }
}
