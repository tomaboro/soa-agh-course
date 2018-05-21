package com.motek.soa;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class TextAnalyzer {
    @WebMethod
    public Report countSpaces(String text){
        return new Report(1,2,3,4);
    }
}
