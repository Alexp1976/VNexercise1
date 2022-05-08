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

		/**
		 * Developer can increase the dividends to checked to print 'Visual Nuts' on the screen
		 * Let's suppose client also wants to check divisibility by 8 also
		 * Develop just need to add 8 to array in bellow code
		 */
		List<Integer> dividends3And5 = Arrays.asList(3, 5); 

		/** 
		 * We might want to check another combination of dividends here, example by 2 and 4
		 * 1. In for statement bellow just add one more call passing a new list of combination to the factory
		 * 2. In DivisibleByMultiple developer must add and verification of the dividends to set the proper message
		 */
		List<Integer> dividends2And4 = Arrays.asList(2, 4);
		
		InputValidator.validateArgument(args);
		
		int value = InputValidator.convertArgument(args);
		
		for (int i = 0; i < value; i++) { 
			checkNumberFactory.verifyNumber(i + 1, dividends3And5);
			// We will add the new combination check bellow
			checkNumberFactory.verifyNumber(i + 1, dividends2And4);
				
			System.out.println(checkNumberFactory.getMessage());
		}
	}

}
