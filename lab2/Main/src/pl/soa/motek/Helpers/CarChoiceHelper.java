package pl.soa.motek.Helpers;

public class CarChoiceHelper {
    public String getBestCar(Double maxPrice, String type) {
        switch (type) {
            case "sportowy":
                if (maxPrice < 20000) return "Lambo";
                else return "Ferrarri";
            case "miejski":
                if (maxPrice < 2000) return "Seicento";
                else return "Fabia";
            default:
                return "Limo";
        }
    }
}