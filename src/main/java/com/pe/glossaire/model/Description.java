package com.pe.glossaire.model;


import javax.persistence.*;

@Entity
@Table(name = "description")
public class Description {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long descriptionId;

    public  String  shortD;

    public  String  longD;

    public Description(){

    }

    public Description(Long descriptionId,String shortD, String longD) {
        this.shortD = shortD;
        this.longD = longD;
    }

    public Long getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(Long descriptionId) {
        this.descriptionId = descriptionId;
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
