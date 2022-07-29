package com.example.libr.core;

import com.example.libr.core.Services.UserService;
import com.example.libr.core.model.tabeluser.Role;
import com.example.libr.core.model.tabeluser.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class LibrApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}


	@Bean
		//testing bean insert data ke database
	CommandLineRunner run(UserService userService)
	{
		return args -> {


			//menambahkan Role
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));


			//menambahkan  user baru
			userService.saveUser(new User(null, "Andi Pertamakita", "andi@gmail.com", "1234", "LK", new ArrayList<>()));
			userService.saveUser(new User(null, "Permatasari", "permatamata@gmail.com", "1234", "P", new ArrayList<>()));
			userService.saveUser(new User(null, "Srikandi Wangi", "wangysrikandi@gmail.com", "1234", "P", new ArrayList<>()));
			userService.saveUser(new User(null, "Wan Da", "wandda@gmail.com", "1234", "LK", new ArrayList<>()));


			//menambahkan role ke spesifik user by email
			userService.addRoleToUser("andi@gmail.com", "ROLE_USER");
			userService.addRoleToUser("permatamata@gmail.com", "ROLE_USER");
			userService.addRoleToUser("wangysrikandi@gmail.com", "ROLE_ADMIN");
			userService.addRoleToUser("wandda@gmail.com", "ROLE_ADMIN");
		};
	}
}
