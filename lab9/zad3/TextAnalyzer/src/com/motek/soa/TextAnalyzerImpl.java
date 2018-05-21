package com.motek.soa;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class TextAnalyzerImpl implements TextAnalyzer {

    @WebMethod
    @Override
    public Report countSpaces(String arg0) {
        Report report = new Report();
        report.setBigCharacters((int) arg0.chars().filter(Character::isUpperCase).count());
        report.setSpaces((int) arg0.chars().filter(Character::isSpaceChar).count());
        report.setCharacters(arg0.length());
        report.setSmallCharacters(report.characters - report.smallCharacters - report.spaces);
        return report;
    }
}
