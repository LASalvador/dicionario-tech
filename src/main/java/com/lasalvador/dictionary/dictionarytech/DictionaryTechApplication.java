package com.lasalvador.dictionary.dictionarytech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DictionaryTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(DictionaryTechApplication.class, args);
	}

}
