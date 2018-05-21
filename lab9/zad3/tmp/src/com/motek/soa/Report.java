package com.motek.soa;

public class Report {
    private int spaces;
    private int characters;
    private int bigCharacters;
    private int smallCharacters;

    public Report() { }

    public Report(int spaces, int characters, int bigCharacters, int smallCharacters) {
        this.spaces = spaces;
        this.characters = characters;
        this.bigCharacters = bigCharacters;
        this.smallCharacters = smallCharacters;
    }

    public int getSpaces() {
        return spaces;
    }

    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }

    public int getCharacters() {
        return characters;
    }

    public void setCharacters(int characters) {
        this.characters = characters;
    }

    public int getBigCharacters() {
        return bigCharacters;
    }

    public void setBigCharacters(int bigCharacters) {
        this.bigCharacters = bigCharacters;
    }

    public int getSmallCharacters() {
        return smallCharacters;
    }

    public void setSmallCharacters(int smallCharacters) {
        this.smallCharacters = smallCharacters;
    }
}
