package com.example.BootMysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BootMysql.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
