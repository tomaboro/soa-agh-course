package com.motek.soa;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Kantor {
    @WebMethod
    public Double zamien(String waluta, Double kwota)  throws UnsupportedCurrencyException {
        switch (waluta) {
            case "PLN":
                return kwota;
            case "GBP":
                return 5 * kwota;
            case "EUR":
                return 4 * kwota;
            case "USD":
                return 3 * kwota;
            default:
                throw new UnsupportedCurrencyException();
        }
    }
}
