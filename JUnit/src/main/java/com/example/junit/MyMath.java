package com.example.junit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


public class MyMath {

	int sum(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}

	int findMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i : arr) {
			if (i > max)
				max = i;
		}
		return max;
	}

	int findMin(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int i : arr) {
			if (i < min)
				min = i;
		}
		return min;
	}
	
}
