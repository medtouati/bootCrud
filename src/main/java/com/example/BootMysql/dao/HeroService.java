package com.example.BootMysql.dao;

import java.util.List;

import com.example.BootMysql.to.HeroTo;

public interface HeroService {
	List<HeroTo> getAllHeros();
	HeroTo AddHero(HeroTo hero);
	HeroTo findByFirstName(String firstName);
	void deleteHeroById(Long id);
	HeroTo findById(Long id);

}
