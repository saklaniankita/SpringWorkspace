package com.example.junit;

public class MyString {
	public String addString(String str1, String str2) {
		return str1.concat("-").concat(str2);
	}
	
	public Boolean containsA(String str) {
		boolean val = (str.contains("A")|| str.contains("a"))?true:false;
		return val;
	}
}
