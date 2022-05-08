package com.visualnuts.exercise.service;

import java.util.List;

public class DivisibleByMultiple extends CheckNumber {

	public DivisibleByMultiple(List<Integer> dividends) {
		
		if (dividends.contains(3) && dividends.contains(5)) {
			this.setMessage("Visual Nuts");
		}
		
		// We would need to check the new combination provided by the customer here to return a proper message
		if (dividends.contains(2) && dividends.contains(4)) {
			this.setMessage("Example how to add new combination check");
		}
	}
}
