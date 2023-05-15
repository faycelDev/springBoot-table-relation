package com.fays.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {


    @Column
    String date;
    @Column
    String nameBook;


    @Id
    @GeneratedValue
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_auteur")
    private Auteur auteur;


    public Book() {

    }

    public Book(String date, String nameBook, Long id) {
        this.date = date;
        this.nameBook = nameBook;
        this.id = id;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}