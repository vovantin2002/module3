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
    @NotBlank(message = "Không được phép để trống")
    @Pattern(regexp = "^[\\w\\s]{1,800}$",message = " không vượt quá 800 ký tự, không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String name;
    @NotBlank(message = "Không được phép để trống")
    @Pattern(regexp = "^[\\w\\s]{1,300}$",message = " không vượt quá 800 ký tự, không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String artist;
    @NotBlank(message = "Không được phép để trống")
    @Pattern(regexp = "^[\\w\\s ,]{1,1000}$",
            message = "không chứa các kí tự đặc biệt như @ ; . = - + , ….")
    private String category;
    private boolean flagDelete;

    public Song() {

    }

    public Song(int id, String name, String artist, String category, boolean flagDelete) {
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

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
