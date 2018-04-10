import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;

@ManagedBean()
@SessionScoped()
public class Samochod {

    private List<String> marki = new ArrayList<>();
    private List<String> modele = new ArrayList<>();
    private String[] silniki = {"ON","benzyna"};
    private HashMap<String,List<String>> markiIModele = new HashMap<>();
    private String marka;
    private String model;
    private String maxCena;
    private String minCena;
    private String typSilnika;
    private String daneOsobowe;
    private String numerTelefonu;
    private Boolean formValid;
    private List<String> wyniki = new ArrayList<>();

    public Samochod() {
        markiIModele.put("Skoda", Arrays.asList("Octavia","Fabia","Superb"));
        markiIModele.put("Opel", Arrays.asList("Corsa","Corsa 2","Corsa 3"));
        markiIModele.put("Fiat", Arrays.asList("Punto","500","Seicento"));

        marki.addAll(markiIModele.keySet());

        modele = markiIModele.get(marki.get(0));

        resetValues();
    }

    public void resetValues(){
        marka = marki.get(0);
        modele = markiIModele.get(marka);
        model = modele.get(0);
        maxCena = "1000000";
        minCena = "0";
        typSilnika = silniki[0];
        daneOsobowe = "";
        numerTelefonu = "";
        formValid = false;
        wyniki.clear();
    }

    public void validateForm(){
        try{
            formValid = !numerTelefonu.isEmpty() && !daneOsobowe.isEmpty() &&
                    Integer.parseInt(minCena) < Integer.parseInt(maxCena);
        }catch (Exception e){
            formValid = false;
        }
    }

    public void evaluate(){
        if(Integer.parseInt(minCena) > 8000) {
            wyniki.clear();
            wyniki.add("Super oferta z Buraczkow dolnych");
            wyniki.add("Najlepsza oferta w internecie");
        } else {
            wyniki.clear();
            wyniki.add("Najszybsza bryka po tej stronie Wisły");
            wyniki.add("Auto z wiejskiego tuningu");
        }
    }

    public List<String> getWyniki() {
        return wyniki;
    }

    public void setWyniki(List<String> wyniki) {
        this.wyniki = wyniki;
    }

    public List<String> getMarki() {
        return marki;
    }

    public void setMarki(List<String> marki) {
        this.marki = marki;
    }

    public List<String> getModele() {
        return modele;
    }

    public void setModele(List<String> modele) {
        this.modele = modele;
    }

    public String[] getSilniki() {
        return silniki;
    }

    public void setSilniki(String[] silniki) {
        this.silniki = silniki;
    }

    public Boolean getFormValid() {
        return formValid;
    }

    public void setFormValid(Boolean formValid) {
        this.formValid = formValid;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
        this.modele = markiIModele.get(marka);
        this.model = modele.get(0);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaxCena() {
        return maxCena;
    }

    public void setMaxCena(String maxCena) {
        this.maxCena = maxCena;
    }

    public String getMinCena() {
        return minCena;
    }

    public void setMinCena(String minCena) {
        this.minCena = minCena;
    }

    public String getTypSilnika() {
        return typSilnika;
    }

    public void setTypSilnika(String typSilnika) {
        this.typSilnika = typSilnika;
    }

    public String getDaneOsobowe() {
        return daneOsobowe;
    }

    public void setDaneOsobowe(String daneOsobowe) {
        this.daneOsobowe = daneOsobowe;
    }

    public String getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(String numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }
}
