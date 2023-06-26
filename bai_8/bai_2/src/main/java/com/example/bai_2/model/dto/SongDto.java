package com.example.bai_2.model.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class SongDto implements Validator {
    @NotBlank(message = "Không được phép để trống, không vượt quá 800 ký tự, không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    @Pattern(regexp = "^[\\w\\s]{1,800}$")
    private String name;
    @NotBlank(message = "Không được phép để trống, không vượt quá 800 ký tự, không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    @Pattern(regexp = "^[\\w\\s]{1,800}$")
    private String artist;
    @NotBlank(message = "Không được phép để trống, không vượt quá 1000 ký tự, không chứa các kí tự đặc biệt như @ ; . = - + , ….")
    @Pattern(regexp = "^[\\w\\s ,]{1,1000}$")
    private String category;

    public SongDto(String name, String artist, String category) {
        this.name = name;
        this.artist = artist;
        this.category = category;
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
