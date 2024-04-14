package com.example.taskmanagerspring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@SpringBootApplication
public class TaskManagerSpringApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Bean
	public PasswordEncoder passwordEncoder(){

		return new BCryptPasswordEncoder();
	}


	@Bean
	public UserDetailsService userDetailsService(){

		UserDetails normalUser = User
				.withUsername("user")
				.password(passwordEncoder().encode("user123"))
				.roles("NORMAL")
				.build();

		return 	new InMemoryUserDetailsManager(normalUser);

	}
	public static void main(String[] args)throws Exception {

		SpringApplication.run(TaskManagerSpringApplication.class, args);

	}
}
