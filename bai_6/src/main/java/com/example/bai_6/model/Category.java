package com.example.bai_6.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorys")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
//    @OneToMany(mappedBy = "category")
//    private List<Blog> blogList;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
//    public Category(int id, String name, List<Blog> blogList) {
//        this.id = id;
//        this.name = name;
//        this.blogList = blogList;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Blog> getBlogList() {
//        return blogList;
//    }
//
//    public void setBlogList(List<Blog> blogList) {
//        this.blogList = blogList;
//    }
}
