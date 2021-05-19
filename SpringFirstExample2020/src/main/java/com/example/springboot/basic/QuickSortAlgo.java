package com.example.springboot.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("quick")
public class QuickSortAlgo implements SortAlgorithm {

	@Override
	public int[] sort(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("****I AM IN QUICKSORT");
		return new int[] {7,8,9};
	}

}
