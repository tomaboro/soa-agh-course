package pl.motek.soa.Model;

import java.util.ArrayList;

public class EkspertPiwny {
    public static ArrayList<String> wybierzPiwo(String kolor){
        ArrayList<String> polecam = new ArrayList<>();
        switch(kolor){
            case("jasne"):
                polecam.add("Kasztelan pszeniczny");
                polecam.add("Zywiec bialy");
                break;
            case("ciemne"):
                polecam.add("Zywiec Portet");
                break;
            case("burszytnowe"):
                polecam.add("Burszytnowy sztorm");
                break;
            case("brazowe"):
                polecam.add("Sok pomaranczowy");
                break;
        }

        return polecam;
    }
}
