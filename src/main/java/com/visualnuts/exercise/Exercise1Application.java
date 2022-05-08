package com.visualnuts.exercise;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import com.visualnuts.exercise.service.CheckNumberFactory;
import com.visualnuts.exercise.validation.InputValidator;

@SpringBootApplication
@Profile("!test")
public class Exercise1Application implements CommandLineRunner {
	
	CheckNumberFactory checkNumberFactory = new CheckNumberFactory();
	
	public static void main(String[] args) {
		SpringApplication.run(Exercise1Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		List<Integer> dividends3And5 = Arrays.asList(3, 5);

		InputValidator.validateArgument(args);
		
		int value = InputValidator.convertArgument(args);
		
		for (int i = 0; i < value; i++) { 
			if (checkNumberFactory.verifyNumber(i + 1, dividends3And5) != null) {
				System.out.println(checkNumberFactory.getMessage());
			} 
		}
	}

}
