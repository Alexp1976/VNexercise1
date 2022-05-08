package com.visualnuts.exercise.validation;

public class InputValidator {

	public static void validateArgument(String... args) {

		if (args.length <= 0) {
			throw new IllegalArgumentException("At least one parameter must be informed");			
		}
		
		if (args.length > 1) {
			throw new IllegalArgumentException("Ony one parameter is accepted");
		}

	}
	
	public static int convertArgument(String... args) {
		
		try {
			return Integer.parseInt(args[0]);
		} catch (Exception e) {
			throw new IllegalArgumentException("Parameter must be a valid Integer number");
		}
	}
}
