package io.github.cepr0.demo;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public PropertiesFactoryBean pairs() {
		PropertiesFactoryBean pairs = new PropertiesFactoryBean();
		pairs.setLocation(new ClassPathResource("pairs.properties"));
		return pairs;
	}

	@Bean
	public GenericFactoryBean handlers() {
		return new GenericFactoryBean<>(DataHandler.class, PayloadData.class);
	}
}
