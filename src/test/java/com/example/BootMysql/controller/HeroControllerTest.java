package com.example.BootMysql.controller;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.BootMysql.dao.HeroService;
import com.example.BootMysql.dao.NoteService;
import com.example.BootMysql.repository.NoteRepository;
import com.example.BootMysql.to.HeroTo;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HeroControllerTest {
	@Autowired
	MockMvc mock;
	@Autowired
	HeroService heroService;
	@Autowired
	ObjectMapper mapper;
	@Autowired
	NoteService noteService;

	@Test
	public void testFindByFirstName() {
		HeroTo hero = this.heroService.findByFirstName("anis");
		Assert.assertEquals(hero.getFirstName(), "anis");
		Assert.assertEquals(hero.getLastName(), "herbadji");

	}
	@Test
	public void testGetAll() throws Exception {
		mock.perform(get("/hero").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status", is("success")))
				.andExpect(jsonPath("$.totalElements", is(3)))
				.andExpect(jsonPath("$.body.size()", is(3)))
				.andDo(print());
				
		
	}
	
	@Test
	public void testCreateHero() throws Exception {
		HeroTo hero = new HeroTo();
		//hero.setId(1L);
		hero.setFirstName("amine");
		hero.setLastName("min");
		System.out.println(this.noteService.findNoteById(6L));
		hero.setNote(this.noteService.findNoteById(4L));
        String request = mapper.writeValueAsString(hero);
        this.mock.perform(post("/hero").accept(MediaType.APPLICATION_JSON)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(request))
        		.andExpect(status().isCreated())
        		.andExpect(jsonPath("$.body.firstName", is("amine")))
        		.andExpect(jsonPath("$.body.lastName", is("min")))
        		.andDo(print());
	}	
}