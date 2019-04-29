package com.example.BootMysql.dao;

import com.example.BootMysql.model.Note;

public interface NoteService {

	Note findNoteById(Long id);

}
