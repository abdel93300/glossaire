package com.pe.glossaire.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "acronym")
public class Acronym {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long acronymId;

    @NotNull
    public String name;


    @OneToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinColumn(name = "description_id")

    public Description description;
    public Date creation;
    public String author;
    public String author_id;
    public boolean obsolete;
    public boolean a_supprimer;
    public String keyword1;
    public String keyword2;
    public String keyword3;


    public Acronym(){

    }

    public Acronym(@NotNull String name, Description description, Date creation, String author, String author_id, boolean obsolete, boolean a_supprimer, String keyword1, String keyword2, String keyword3) {
        this.name = name;
        this.description = description;
        this.creation = creation;
        this.author = author;
        this.author_id = author_id;
        this.obsolete = obsolete;
        this.a_supprimer = a_supprimer;
        this.keyword1 = keyword1;
        this.keyword2 = keyword2;
        this.keyword3 = keyword3;
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


    public void setCreation(Date creation) {this.creation = creation;}

    public Long getAcronymId() {
        return acronymId;
    }

    public void setAcronymId(Long acronymId) {
        this.acronymId = acronymId;
    }

    @DateTimeFormat(pattern="dd/MMM/YYYY")
    public Date getCreation() {
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

    public String getAuthor_id() {return author_id;}

    public void setAuthor_id(String author_id) {this.author_id = author_id;}

    public boolean isA_supprimer() {return a_supprimer;}

    public void setA_supprimer(boolean a_supprimer) {this.a_supprimer = a_supprimer;}
}

