package com.example.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;


@ExtendWith(MockitoExtension.class)
public class AnnotationMockTest {
	
	@Mock
	DataService dataServicemock;
	
	@InjectMocks
	SomeBusinessImpl someBusinessImpl;
	
	@Test
	void testFindTheGreatestNumber() {
		when(dataServicemock.retrieveAllData()).thenReturn(new int[] {2,3,4});
		assertEquals(4, someBusinessImpl.findTheGreatestNumber());
	}
	
	@Test
	void testFindTheGreatestNumberForSingleValue() {
		when(dataServicemock.retrieveAllData()).thenReturn(new int[] {2});
		assertEquals(2, someBusinessImpl.findTheGreatestNumber());
	}
	
	@Test
	void testFindTheGreatestNumberForNegativeValues() {
		when(dataServicemock.retrieveAllData()).thenReturn(new int[] {-2,-3,-4});
		assertEquals(-2, someBusinessImpl.findTheGreatestNumber());
	}
}
