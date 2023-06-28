package com.example.bai_1.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int quantity;
    private String author;
    @OneToMany(mappedBy = "book")
    private List<Oder> oderList;

    public Book() {
    }

    public Book(int id, String title, int quantity, String author, List<Oder> oderList) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.author = author;
        this.oderList = oderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Oder> getOderList() {
        return oderList;
    }

    public void setOderList(List<Oder> oderList) {
        this.oderList = oderList;
    }
}

