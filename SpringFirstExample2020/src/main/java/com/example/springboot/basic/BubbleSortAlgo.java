package com.example.springboot.basic;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class BubbleSortAlgo implements SortAlgorithm {

	@Override
	public int[] sort(int[] arr) {
		System.out.println("*********I AM IN BUBBLE SORT");
		return arr;
	}

}
