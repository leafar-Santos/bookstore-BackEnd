package com.santos.bookstore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.santos.bookstore.services.DBServices;

@Configuration
@Profile("dev")
public class DevConfig {

	private DBServices dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean intanciaBaseDeDados() {
		
		if(strategy.equals("create")) {
			this.dbService.instaciaBaseDeDados();
		}
			return false;
	}
}
