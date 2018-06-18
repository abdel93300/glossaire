package com.pe.glossaire.model;

public class Description {
    public  String  shortD;
    public  String  longD;

    public Description(String shortD, String longD) {
        this.shortD = shortD;
        this.longD = longD;
    }

    public String getShortD() {
        return shortD;
    }

    public void setShortD(String shortD) {
        this.shortD = shortD;
    }

    public String getLongD() {
        return longD;
    }

    public void setLongD(String longD) {
        this.longD = longD;
    }
}
