package com.springjava;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springjava.model.Role;
import com.springjava.repository.RoleRepository;

@SpringBootApplication
public class HeplApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeplApplication.class, args);
		System.out.println("server started..");
	}
	 @Bean
	    public CommandLineRunner demo(RoleRepository roleRepo) {
	        return (args) -> {
	            Role role=new Role();
	            role.setName("ROLE_ADMIN");
	            roleRepo.save(role);
	        };
}
}
