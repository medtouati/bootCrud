package com.example.BootMysql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.BootMysql.common.GlobalStatus;
import com.example.BootMysql.common.Message;
import com.example.BootMysql.common.Response;
import com.example.BootMysql.dao.HeroService;
import com.example.BootMysql.exception.ResourceNotFoundException;
import com.example.BootMysql.model.Hero;
import com.example.BootMysql.to.HeroTo;

@RestController
@RequestMapping("/hero")
//@PropertySource(value = "message.properties")
public class HeroController {

	@Autowired
	HeroService heroService;
	@Autowired
	Message message;
	
	@GetMapping
	public Response getHeros() {
		List<HeroTo>list = new ArrayList<>();
		Response response = new Response();
		try {
			list = this.heroService.getAllHeros();
			response.setStatus(GlobalStatus.SUCCESS.getStatus());
			response.setCode(200);
			response.setMessage(message.get("list.heros.success"));
			response.setTotalElements(list.size());
			response.setBody(list);
		}catch (ResourceNotFoundException e) {
			// TODO: handle exception
			response.setStatus("empty list");
			response.setCode(199);
			response.setMessage(message.get("list.heros.fail"));
			response.setTotalElements(list.size());
			response.setBody(list);
		}
		return response;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Response addHero(@RequestBody HeroTo heroto) {
		HeroTo hero = this.heroService.AddHero(heroto);
		Response response = new Response();
		response.setCode(200);
		response.setStatus("added");
		response.setBody(hero);
		response.setMessage("new hero added successfuly");
		return response;
	}
	@DeleteMapping("/delete/{id}")
	public Response deleteHero(@PathVariable("id") Long id) {
		Response response = new Response();
			 this.heroService.deleteHeroById(id);
			 response.setCode(200);
			 response.setStatus("success");
			 response.setMessage("deleted successfuly");		
		return response;
	}
}
