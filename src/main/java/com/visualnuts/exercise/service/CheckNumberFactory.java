package com.visualnuts.exercise.service;

import java.util.List;

import org.springframework.util.CollectionUtils;

public class CheckNumberFactory {

	private CheckNumber checkNumber;
	
	public CheckNumber verifyNumber(int number, List<Integer> dividends) {
			
		checkNumber = null;
		
		if (CheckNumber.isDivisibleBy(number, 3)) {
			checkNumber = new DivisibleBy3();
		} 
		
		if (CheckNumber.isDivisibleBy(number, 5)) {
			checkNumber = new DivisibleBy5();
		}
		
		if (!CollectionUtils.isEmpty(dividends) && CheckNumber.isDivisibleByMultiple(number, dividends)) {
			checkNumber = new DivisibleByMultiple(dividends);
		}

		if (checkNumber == null) {
			checkNumber = new NotDivisibleByAny(number);			
		}
		
		return checkNumber;
	}
	
	public String getMessage() {
		
		return checkNumber.getMessage();
		
	}
	
	public CheckNumber getConcreteClass() {
		
		return checkNumber;
	}
}
