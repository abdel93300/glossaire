package com.pe.glossaire.model;



public class AcronymForm {

    private Long acronymId;


    public String name;


    private Description description;
    private String creation;
    public String author;
    private boolean obsolete;
    private String keyword1;
    private String keyword2;
    private String keyword3;






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

    public Long getAcronymId() {
        return acronymId;
    }

    public void setAcronymId(Long acronymId) {
        this.acronymId = acronymId;
    }

    public String getCreation() {
        return creation;
    }


    public void setObsolete(boolean obsolete) {
        this.obsolete = obsolete;
    }

    public String getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1;
    }

    public String getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(String keyword2) {
        this.keyword2 = keyword2;
    }

    public String getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(String keyword3) {
        this.keyword3 = keyword3;
    }

    @Override
    public String toString() {
        return "Acronym{" +
                "acronymId=" + acronymId +
                ", name='" + name + '\'' +
                ", description=" + description +
                ", creation='" + creation + '\'' +
                ", author='" + author + '\'' +
                ", obsolete=" + obsolete +
                ", keyword1='" + keyword1 + '\'' +
                ", keyword2='" + keyword2 + '\'' +
                ", keyword3='" + keyword3 + '\'' +
                '}';
    }
}

