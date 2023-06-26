package com.example.bai_2.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Không được phép để trống, không vượt quá 800 ký tự, không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    @Pattern(regexp = "^[\\w\\s]{1,800}$")
    private String name;
    @NotBlank(message = "Không được phép để trống, không vượt quá 800 ký tự, không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    @Pattern(regexp = "^[\\w\\s]{1,800}$")
    private String artist;
    @NotBlank(message = "Không được phép để trống, không vượt quá 1000 ký tự, không chứa các kí tự đặc biệt như @ ; . = - + , ….")
    @Pattern(regexp = "^[\\w\\s ,]{1,1000}$")
    private String category;
    private Boolean flagDelete;

    public Song() {

    }

    public Song(int id, String name, String artist, String category, Boolean flagDelete) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.category = category;
        this.flagDelete = flagDelete;
    }

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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
