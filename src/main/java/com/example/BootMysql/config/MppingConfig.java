package com.example.BootMysql.config;


import javax.sql.DataSource;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.hibernate.HibernateError;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.BootMysql.model.Hero;
import com.example.BootMysql.to.HeroTo;

@Configuration
public class MppingConfig {
	@Bean
	public BeanMappingBuilder beanMappingBuilder() {
		return new BeanMappingBuilder() {
			
			@Override
			protected void configure() {
				// TODO Auto-generated method stub
				mapping(Hero.class, HeroTo.class);
			}
		};
	}
	@Bean
	public DozerBeanMapper beanMapper() {
	    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
	    dozerBeanMapper.addMapping(beanMappingBuilder());
	    return dozerBeanMapper;
	}
	
	//@ConfigurationProperties(prefix = "anis.datasource.mysql")
	


}
