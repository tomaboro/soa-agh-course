package com.motek.soa;

public class Client {
    public static void main(String[] args) {
        HolidaysCountDownService service = new HolidaysCountDownService();
        HolidaysCountDown hcd = service.getHolidaysCountDownPort();
        System.out.println(hcd.getCount());
    }
}