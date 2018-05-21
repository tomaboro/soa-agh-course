package com.motek.soa;

public class Main {
    public static void main(String[] args) {
        KantorService service = new KantorService();
        Kantor kantor = service.getKantorPort();
        try {
            System.out.println(kantor.zamien("GBP",250.0));
        } catch (UnsupportedCurrencyException_Exception e) {
            e.printStackTrace();
        }
    }
}
