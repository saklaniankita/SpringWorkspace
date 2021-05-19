package com.example.mockito;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ListMockTest {

	@Test
	public void testSize() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(10);
		assertEquals(10, mockList.size());
		assertEquals(10, mockList.size());
		assertEquals(10, mockList.size());
	}
	
	@Test
	public void testSizeMultipeReturns() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, mockList.size());
		assertEquals(20, mockList.size());
		assertEquals(20, mockList.size());
	}
	
	//get(0) will return "SomeString", any other index in get() method will
	//return NULL
	@Test
	public void testGet_specificParameter() {
		List mockList = mock(List.class);
		when(mockList.get(0)).thenReturn("SomeString");
		assertEquals("SomeString", mockList.get(0));
		assertNull(mockList.get(1));
		assertNull(mockList.get(2));
	}
	
	/**
	 * get() method will return the same output for any index
	 * 
	 * If there are more than one argument, then all of must must be either
	 * specific OR all of them must be generic
	 */
	@Test
	public void testGet_genericParameter() {
		List mockList = mock(List.class);
		when(mockList.get(Mockito.anyInt())).thenReturn("SomeString");
		assertEquals("SomeString", mockList.get(0));
		assertEquals("SomeString", mockList.get(100));
		assertEquals("SomeString", mockList.get(-1));
		assertEquals("SomeString", mockList.get(-100));
	}
}
