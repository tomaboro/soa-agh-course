package pl.motek.soa.Model;

public class Movie {
    private String title;
    private String genere;
    private Integer year;
    private Integer gain;

    public Movie(String title, String genere, Integer year, Integer gain) {
        this.title = title;
        this.genere = genere;
        this.year = year;
        this.gain = gain;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getGain() {
        return gain;
    }

    public void setGain(Integer gain) {
        this.gain = gain;
    }
}
