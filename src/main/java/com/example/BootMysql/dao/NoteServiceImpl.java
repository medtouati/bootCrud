package com.example.BootMysql.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BootMysql.model.Note;
import com.example.BootMysql.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService{

	@Autowired
	NoteRepository noteRepository;
	
	@Override
	public Note findNoteById(Long id) {
		return this.noteRepository.findById(id).get();
	}
}
