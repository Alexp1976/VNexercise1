package com.visualnuts.exercise;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.visualnuts.exercise.service.CheckNumberFactory;
import com.visualnuts.exercise.service.DivisibleBy3;
import com.visualnuts.exercise.service.DivisibleBy5;
import com.visualnuts.exercise.service.DivisibleByMultiple;
import com.visualnuts.exercise.service.NotDivisibleByAny;
import com.visualnuts.exercise.validation.InputValidator;

@ActiveProfiles("test")
@SpringBootTest
class Exercise1ApplicationTests {
		
	@Test
	void noArgumentPassed() {
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			InputValidator.validateArgument();
		});
		
		assertEquals(IllegalArgumentException.class, exception.getClass());
		
	}
	
	@Test
	void moreThanOneArgumentPassed() {
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			InputValidator.validateArgument("100", "200");
		});
		
		assertEquals(IllegalArgumentException.class, exception.getClass());

	}
	
	@Test
	void invalidIntegerNumber() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			InputValidator.convertArgument("A");
		});
		
		assertEquals(IllegalArgumentException.class, exception.getClass());

	}
	
	@Test
	void validateDivisibleBy3() {
		
		CheckNumberFactory factory = new CheckNumberFactory();
		
		int number = 3;
		
		factory.verifyNumber(number, null);
		
		assertEquals("Visual", factory.getMessage());
		assertTrue(factory.getConcreteClass() instanceof DivisibleBy3);
	}

	@Test
	void validateDivisibleBy5() {
		
		CheckNumberFactory factory = new CheckNumberFactory();
		
		int number = 5;
		
		factory.verifyNumber(number, null);
		
		assertEquals("Nuts", factory.getMessage());
		assertTrue(factory.getConcreteClass() instanceof DivisibleBy5);
	}
	
	@Test
	void validateDivisibleBy3And5() {
		
		CheckNumberFactory factory = new CheckNumberFactory();
		
		int number = 15;
		List<Integer> dividends = Arrays.asList(3, 5);
		
		factory.verifyNumber(number, dividends);
		
		assertEquals("Visual Nuts", factory.getMessage());
		assertTrue(factory.getConcreteClass() instanceof DivisibleByMultiple);
	}
	
	@Test
	void validadeNotDivisibleByAny() {
		
		CheckNumberFactory factory = new CheckNumberFactory();
		
		int number = 8;
		
		factory.verifyNumber(number, null);
		
		assertEquals(Integer.toString(number), factory.getMessage());
		assertTrue(factory.getConcreteClass() instanceof NotDivisibleByAny);
	}
}
