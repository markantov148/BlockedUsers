package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.BlockedUsers;
import com.example.demo.repo.BlockedUsersRepository;

@SpringBootApplication
public class BlockedUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockedUsersApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {

			@Autowired
			BlockedUsersRepository repo;
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				repo.save(new BlockedUsers(111, "ABC", "JAVA", LocalDate.now(), true));  
				repo.save(new BlockedUsers(222, "XYZ", "DS", LocalDate.now(), true));  
				repo.save(new BlockedUsers(333, "LMN", "UXD", LocalDate.now(), true));  
				repo.save(new BlockedUsers(444, "IJK", "DEV", LocalDate.now(), false));  

			}
			
			
		};
	}
}
