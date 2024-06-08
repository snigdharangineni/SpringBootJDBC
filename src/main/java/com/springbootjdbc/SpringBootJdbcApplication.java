package com.springbootjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springbootjdbc.model.Alien;
import com.springbootjdbc.repository.AlienRepository;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
		
		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(111);
		alien1.setName("Snigdha");
		alien1.setTech("Java");
		
		AlienRepository repo = context.getBean(AlienRepository.class);
		repo.save(alien1);
		
		System.out.println(repo.findAll());
		
	}

}
