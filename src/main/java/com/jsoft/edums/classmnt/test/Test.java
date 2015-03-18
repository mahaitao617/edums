package com.jsoft.edums.classmnt.test;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		String date = new Date().toString();
		System.out.println(date.substring(date.length() - 2, date.length()));
	}
}
