package com.example.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Here we are using a stub for a dummy data.
 * Every time we need to run a different test case with a different scenario
 * (say an empty array, or just one element array), we'll have to write 
 * a different stub/class
 * To deal with this problem, we use mocks
 * Mocking helps to dynamically create different classes
 * @author Ankita
 *
 */
class SomeBusinessImplStubTest {

	@Test
	void testFindTheGreatestNumber() {
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(new DataserviceStub());
		int num = someBusinessImpl.findTheGreatestNumber();
		assertEquals(6, num);
		
	}
	
	class DataserviceStub implements DataService{

		@Override
		public int[] retrieveAllData() {
			//returning dummy data
			return new int[] {2,4,3,6};
		}
		
	}

}
