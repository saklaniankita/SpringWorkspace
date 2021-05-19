package com.example.junit;

/**
 * test folder should never be included in war/jar file
 * 
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@SpringBootTest
@DisplayName("JUNIT TEST CLASS")
class JunitApplicationTests {
	
	private static Logger LOGGER = LoggerFactory.getLogger(JunitApplicationTests.class);
	
	private MyMath myMath = new MyMath();
	
	@BeforeAll
	static void setUp() {
		LOGGER.info("BeforeAllmethod called......");
	}
	
	@BeforeEach
	void init() {
		LOGGER.info("Before every method......");
	}

	@DisplayName("Sum Test Method")
	@Tag("SUM")
	@Test
	void testSum() {
		assertEquals(10, myMath.sum(new int[] {1,2,3,4}));
	}
	
	@Test
	@Tag("SUM")
	void testSum_1() {
		assertEquals(0, myMath.sum(new int[] {-1,1}));
	}
	
	@Test
	@Tag("SUM")
	void testSum_2() {
		assertEquals(0, myMath.sum(new int[] {0}));
	}
	
	@Disabled("Not to be Executed")
	@Test
	void testFindMax() {
		assertEquals(4, myMath.findMax(new int[] {1,2,3,4}));
	}
	
	@DisplayName("Finding Minimum Number")
	@Test
	void testFindMin() {
		assertEquals(1, myMath.findMin(new int[] {1,2,3,4}));
	}
	
	 @Test
	 void groupAssertions() {
	     int[] numbers = {0, 1, 2, 3, 4};
	     assertAll("numbers",
	         () -> assertEquals(numbers[0], 0),
	         () -> assertEquals(numbers[3], 3),
	         () -> assertEquals(numbers[4], 4)
	     );
	 }
	
	@AfterEach
	void teardown() {
		LOGGER.info("After every Method........");
	}
	
	@AfterAll
	static void done() {
		LOGGER.info("After all the methods......");
	}
	
	
}
