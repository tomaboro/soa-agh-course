package com.motek.soa;


import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

@WebService
public class HolidaysCountDown {
    @WebMethod
    public Long getCount() {
        LocalDate now = LocalDate.now();
        LocalDate holidays = LocalDate.parse("01/07/2018", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Duration duration = Duration.between(now.atStartOfDay(), holidays.atStartOfDay());
        return Math.abs(duration.toDays());
    }
}
