package com.example.bai_2.service;

import com.example.bai_2.ISongRepository;
import com.example.bai_2.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> display() {
        return songRepository.findAll();
    }

    @Override
    public void create(Song song) {
        songRepository.save(song);
    }

    @Override
    public void update(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song showFormEdit(int id) {
        return songRepository.findById(id).get();
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        for (int i = 0; i < songRepository.findAll().size(); i++) {
            if (songRepository.findAll().get(i).getId() == id) {
                songRepository.deleteById(id);
                flag = true;
            }
        }
        return flag;
    }
}
