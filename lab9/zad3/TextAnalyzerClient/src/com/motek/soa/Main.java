package com.motek.soa;

import org.apache.axis2.AxisFault;

public class Main {
    public static void main(String[] args) {
        try {
            TextAnalyzerServiceStub serviceStub = new TextAnalyzerServiceStub();
            TextAnalyzerServiceStub.CountSpacesE c = new TextAnalyzerServiceStub.CountSpacesE();
            c.getCountSpaces().s
            serviceStub.countSpaces()
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }
}
