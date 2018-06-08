package com.pe.glossaire;


public class Acronym {
    public String name;
    public Description description;
    public String creation;
    public String author;
    public boolean obsolete;
    public String[] motClefs;


    public Acronym(String name, Description description, String creation, String author, boolean obsolete, String[] motClefs) {
        this.name = name;
        this.description = description;
        this.creation = creation;
        this.author = author;
        this.obsolete = obsolete;
        this.motClefs = motClefs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isObsolete() {
        return obsolete;
    }


    public void setCreation(String creation) {this.creation = creation;}

    public void setObsolete(boolean obsolete) {
        this.obsolete = obsolete;
    }

    public String[] getMotClefs() {return motClefs;}

    public void setMotClefs(String[] motClefs) {this.motClefs = motClefs;}
}
