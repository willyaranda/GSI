package com.willyaranda.gsi.ej2;

public class Suma {
	
	final int total = 50;
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	private int num1 = 0;
	private int num2 = 0;
	
	public Suma() {
		// TODO Auto-generated constructor stub
	}
	
	public Suma(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public boolean isCorrect() {
		int suma = num1 + num2;
		return (suma == total) ? true : false;
	}
	

}
