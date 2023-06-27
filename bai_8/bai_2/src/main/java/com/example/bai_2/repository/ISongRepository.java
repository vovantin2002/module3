package com.example.bai_2.repository;

import com.example.bai_2.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ISongRepository extends JpaRepository<Song,Integer> {
    @Modifying
    @Transactional
    @Query(value = "update songs as s set flag_delete = 1 where s.id = :id ", nativeQuery = true)
    void isDelete(@Param(value = "id") Integer id);
}
