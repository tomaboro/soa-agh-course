package com.motek.soa;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Provider;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/HolidaysService_war_exploded/HolidaysCountDown?wsdl");
            QName qName = new QName("http://soa.motek.com/","HolidaysCountDownService");

            Service service = Service.create(url,qName);
            HolidaysCountDown hcd = service.getPort(HolidaysCountDown.class);
            System.out.println(hcd.getCount());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
