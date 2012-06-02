package com.willyaranda.gsi.ej2;

/**
 * Checks the sum of two given numbers to be equal to our super-secret number
 * @author willyaranda
 *
 */
public class CheckSuma {
	
	/**
	 * Shhhh... this is secret
	 */
	final static int total = 50;
	
	/**
	 * Check if the sum is correct
	 * @param num1
	 * @param num2
	 * @return is the sum of this two numbers equal to our secret number?
	 */
	public static boolean isCorrect(int num1, int num2) {
			int suma = num1 + num2;
			return (suma == total) ? true : false;
	}
}
