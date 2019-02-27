package com.viniciussaraiva.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.viniciussaraiva.workshopmongo.domain.User;
import com.viniciussaraiva.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria =  new User(null,"Maria Brown", "maria@gmail.com");
		User vinicius =  new User(null,"Vinicius Silva", "vinicius@gmail.com");
		User jose =  new User(null,"Jose Brown", "jose@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,vinicius,jose));
	}

}
