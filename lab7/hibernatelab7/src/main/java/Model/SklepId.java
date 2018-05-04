package Model;

import javax.persistence.Id;
import java.io.Serializable;

public class SklepId implements Serializable {
    private int artykul;
    private String dostawca;

    public SklepId(){}

    public SklepId(int artykul, String dostawca) {
        this.artykul = artykul;
        this.dostawca = dostawca;
    }

    public int getArtykul() {
        return artykul;
    }

    public void setArtykul(int artykul) {
        this.artykul = artykul;
    }

    public String getDostawca() {
        return dostawca;
    }

    public void setDostawca(String dostawca) {
        this.dostawca = dostawca;
    }
}
