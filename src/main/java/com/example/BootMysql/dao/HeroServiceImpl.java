package com.example.BootMysql.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BootMysql.exception.ResourceNotFoundException;
import com.example.BootMysql.model.Hero;
import com.example.BootMysql.repository.HeroRepository;
import com.example.BootMysql.to.HeroTo;

@Service
public class HeroServiceImpl implements HeroService {

	@Autowired
	HeroRepository heroRepository;
	@Autowired
	DozerBeanMapper mapper;

	@Override
	public List<HeroTo> getAllHeros() {
		List<HeroTo> heros = this.heroRepository.findAll().stream().
				map(entity -> mapper.map(entity, HeroTo.class)).collect(Collectors.toList());
		if(heros.isEmpty()) {
			throw new ResourceNotFoundException("Hero", "hero", null);
		}
		return heros;
	}
	@Override
	public HeroTo AddHero(HeroTo heroto) {
		Hero hero = this.mapper.map(heroto, Hero.class);
		Hero addedHero = this.heroRepository.save(hero);
		return this.mapper.map(addedHero, HeroTo.class);
		
	}
	@Override
	public HeroTo findByFirstName(String firstName) {
		Hero hero = this.heroRepository.findByFirstName(firstName);
		return this.mapper.map(hero, HeroTo.class);
		
	}
	@Override
	public void deleteHeroById(Long id) {
		if(this.heroRepository.findById(id).isPresent()) {
			this.heroRepository.deleteById(id);
		}else {
			throw new ResourceNotFoundException("Hero", "id", id);
		}		
	}
	@Override
	public HeroTo findById(Long id) {
		Hero hero = this.heroRepository.findById(id).get();
		return this.mapper.map(hero, HeroTo.class);
		
	}
}
