package com.algaworks.osworks.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	/**
	 * 
	 * Criamos essa Classe para validar a dependência ModelMapper , instanciando-a e
	 * tranformando-a em um
	 * 
	 * @Bean
	 * 
	 * Para usa-la na Representation Model 
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
