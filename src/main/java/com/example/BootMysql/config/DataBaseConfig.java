package com.example.BootMysql.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;



/**
 * @author sandro
 * @since 11-08-2018
 *
 */
@Configuration
@PropertySource(value = "db.properties")
public class DataBaseConfig {

	@Value("${anis.datasource.url}")
	private String url;
	@Value("${anis.datasource.username}")
	private String username;
	@Value("${anis.datasource.password}")
	private String password;
	
	@Bean
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create().url(url)
				.username(username)
				.password(password)
				.build();
	}

	
	/*@Bean
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create().url("jdbc:mysql://localhost:3306/note_app?useSSL=false")
				.username("root")
				.password("")
				.build();
	}*/
}
