package com.visualnuts.exercise.service;

import java.util.List;

public class DivisibleByMultiple extends CheckNumber {

	public DivisibleByMultiple(List<Integer> dividends) {
		
		if (dividends.contains(3) && dividends.contains(5)) {
			this.setMessage("Visual Nuts");
		}

	}
}
