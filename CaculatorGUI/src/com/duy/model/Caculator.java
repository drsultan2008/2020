package com.duy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.duy.utils.Observable;

public class Caculator extends Observable {
	private String line;
	private double res;
	private double resOdd;

	public Caculator() {
		line = "";
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getLine() {
		return line;
	}

	public double getResOdd() {
		return resOdd;
	}

	public void setResOdd(double resOdd) {
		this.resOdd = resOdd;
	}

	public void execute(String line) {
		setLine(line);
		List<String> list = new ArrayList<>();
		String piece = "";
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) != '/' && line.charAt(i) != '-' && line.charAt(i) != 'x' && line.charAt(i) != '+') {
				piece += line.charAt(i);
			} else {
				list.add(piece);
				list.add(Character.toString(line.charAt(i)));
				piece = "";
			}
		}

		list.add(piece);

//		for (String i:list) {
//			System.out.print(i+" ");
//		}

		List post = toPostfix(list);
		this.res = evalutionPostfix(post);
		notifier();
	}

	private int priority(Character c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case 'x':
		case '/':
			return 2;
		}

		return -1;
	}

	private List<String> toPostfix(List<String> infix) {
		List<String> result = new ArrayList<>();
		Stack<String> stack = new Stack<>();

		for (String i : infix) {
			if (!i.equals("/") && !i.equals("x") && !i.equals("-") && !i.equals("+")) {
				result.add(i);
			}
			else {
				while (!stack.isEmpty() && priority(i.charAt(0)) <= priority(stack.peek().charAt(0))) {
					result.add(stack.pop());
				}
				
				stack.push(i);
			}
		}
		
		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}
		System.out.println(result);
		return result;
	}
	
	private double evalutionPostfix(List<String> list) {
		Stack<Double> stack = new Stack<>();
		
		for (String i:list) {
			if (!i.equals("/") && !i.equals("x") && !i.equals("-") && !i.equals("+")) {
				stack.push(Double.parseDouble(i));
			}
			else {
				double one = stack.pop();
				double two = stack.pop();
				
				if (i.equals("+")){
					stack.push(one+two);
				}
				else if (i.equals("-")){
					stack.push(one-two);
				}
				else if (i.equals("x")){
					stack.push(one*two);
				}
				else if (i.equals("/")){
					stack.push(two/one);
				}
			}
		}
		
		return stack.pop();
	}

	public double getRes() {
		return res;
	}

	public void setRes(double res) {
		
		notifier();
	}

	public void setArg(double x) {
//		if (isActive) {
//			numB+=Integer.toString((int)x);
//			System.out.println(numB);
//			setB(Double.parseDouble(numB));
//		} else {
//			numA+=Integer.toString((int)x);
//			System.out.println(numA);
//			setA(Double.parseDouble(numA));
//		}

	}

}
