package com.example.bai_2.service;

import com.example.bai_2.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> display();

    void create(Song song);

    void update(Song song);

    Song showFormEdit(int id);

    boolean delete(int id);
}
