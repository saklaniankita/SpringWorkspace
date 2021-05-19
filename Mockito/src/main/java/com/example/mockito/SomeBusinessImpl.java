package com.example.mockito;

public class SomeBusinessImpl {
	private DataService dataservice;

	public SomeBusinessImpl(DataService dataservice) {
		super();
		this.dataservice = dataservice;
	}
	int findTheGreatestNumber() {
		int[] data = dataservice.retrieveAllData();
		int greatest = Integer.MIN_VALUE;
		for (int i : data) {
			if (i > greatest)
				greatest = i;
		}
		return greatest;
	}
}

