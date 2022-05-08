package com.visualnuts.exercise.service;

import java.util.List;

public abstract class CheckNumber {

	private StringBuilder message = new StringBuilder();
		
	public String getMessage() {
		return message.toString();
	}
	
	public void setMessage(String message) {
		this.message.append(message);
	}
	
	public static boolean isDivisibleBy(int number, int dividend) {
		
		return number % dividend == 0;
	}
	
	public static boolean isDivisibleByMultiple(int number, List<Integer> dividends) {
		
		boolean isDivisible = true;
		int index = 0;
		
		do {
			isDivisible = number % dividends.get(index) == 0;
			index++;
		} while (isDivisible && index < dividends.size());
		
		return isDivisible;
	}
}
