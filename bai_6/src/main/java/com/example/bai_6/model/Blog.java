package com.example.bai_6.model;

import javax.persistence.*;


@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "LongText")
    private String title;
    @Column(columnDefinition = "LongText")
    private String content;
    private String postingDate;
    private String author;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Blog() {
    }

    public Blog(int id, String title, String content, String postingDate, String author, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.postingDate = postingDate;
        this.author = author;
        this.category = category;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
