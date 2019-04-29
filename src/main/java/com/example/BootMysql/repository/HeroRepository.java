package com.example.BootMysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BootMysql.model.Hero;

public interface HeroRepository extends JpaRepository<Hero, Long> {

	public Hero findByFirstName(String firstName);
}
