package com.example.bai_2.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class SongDto implements Validator {
    private int id;
    @NotBlank(message = "Không được phép để trống, không vượt quá 800 ký tự, không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    @Pattern(regexp = "^[\\w\\s]{1,800}$")
    private String name;
    @NotBlank(message = "Không được phép để trống, không vượt quá 800 ký tự, không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    @Pattern(regexp = "^[\\w\\s]{1,300}$")
    private String artist;
    @NotBlank
    @Pattern(regexp = "^[\\w\\s ,]{1,1000}$",
            message = "Không được phép để trống, không vượt quá 1000 ký tự, không chứa các kí tự đặc biệt như @ ; . = - + , ….")
    private String category;
    private boolean flagDelete;

    public SongDto() {
    }

    public SongDto(int id, String name, String artist, String category, boolean flagDelete) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (songDto.getCategory().matches("^[\\w\\s ,]{1,1000}$")) {
            errors.rejectValue("category", "category",
                    "Không được phép để trống, không vượt quá 1000 ký tự, không chứa các kí tự đặc biệt như @ ; . = - + , ….");
        }
        if (songDto.getName().matches("^[\\w\\s]{1,800}$")) {
            errors.rejectValue("name", "name",
                    "Không được phép để trống, không vượt quá 800 ký tự, không chứa các kí tự đặc biệt như @ ; , . = - + , ….");
        }
        if (songDto.getArtist().matches("^[\\w\\s]{1,800}$")) {
            errors.rejectValue("artist", "artist",
                    "Không được phép để trống, không vượt quá 800 ký tự, không chứa các kí tự đặc biệt như @ ; , . = - + , ….");
        }
    }
}
