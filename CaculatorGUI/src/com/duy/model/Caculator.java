package com.duy.model;

public class Caculator {
	private double a;
	private double b;
	private double res;
	
	public Caculator() {
		a=0;
		b=0;
		res=0;
	}
	
	public double add(double a, double b) {
		res = a+b;
		return a+b;
	}
	
	public double sub(double a, double b) {
		res = a-b;
		return a-b;
	}
	
	public double product(double a, double b) {
		res = a*b;
		return a*b;
	}
	
	public double divide(double a, double b) {
		res = a/b;
		return a/b;
	}
}
