package com.example.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

/**
 * We can create mocks of either interfaces or classes and make them
 * return whatever data we want.
 * 
 * It is a good practice to use mock because it removes the dependency 
 * on actual data. So even if the actual data is not available or 
 * the database is down, we can still run our tests and check the 
 * functionality of the business layers
 * 
 * You must pass the mock in the class you would want to test through
 * constructor or setter injection.
 * 
 * Here we are passing "dataServicemock" to the class "SomeBusinessImpl"
 *(which has findTheGreatestNumber() method which needs to be tested)
 * through constructor injection
 * 
 * @author Ankita
 *
 */
public class SomeBusinessImplMockTest {
	DataService dataServicemock = mock(DataService.class);
	
	@Test
	void testFindTheGreatestNumber() {
		when(dataServicemock.retrieveAllData()).thenReturn(new int[] {2,3,4});
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServicemock);
		assertEquals(4, someBusinessImpl.findTheGreatestNumber());
	}
	
	@Test
	void testFindTheGreatestNumberForSingleValue() {
		when(dataServicemock.retrieveAllData()).thenReturn(new int[] {2});
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServicemock);
		assertEquals(2, someBusinessImpl.findTheGreatestNumber());
	}
	
	@Test
	void testFindTheGreatestNumberForNegativeValues() {
		when(dataServicemock.retrieveAllData()).thenReturn(new int[] {-2,-3,-4});
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServicemock);
		assertEquals(-2, someBusinessImpl.findTheGreatestNumber());
	}
}
