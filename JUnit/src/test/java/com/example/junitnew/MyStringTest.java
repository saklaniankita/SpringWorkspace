package com.example.junitnew;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.junit.MyString;

@DisplayName("STRING TEST CLASS")
public class MyStringTest {
	private static Logger LOGGER = LoggerFactory.getLogger(MyStringTest.class);

	private MyString myString = new MyString();

	@BeforeAll
	static void setUp() {
		LOGGER.info("BeforeAllmethods called......");
	}

	@BeforeEach
	void init() {
		LOGGER.info("Before every method......");
	}
	
	@Test
	@DisplayName("Adding String")
	public void testAddString(){
		assertEquals("spring-boot",myString.addString("spring", "boot"));
	}
	
	@Test
	@Disabled
	public void testContainsA() {
		assertTrue(myString.containsA("abc"));
	}
}
