package com.duy.utils;

import java.util.ArrayList;

public class Observable {
	private ArrayList<Observer> observers = new ArrayList<>();
	
	public void add(Observer observer) {
		observers.add(observer);
	}
	
	public void notifier() {
		for (Observer o:observers) {
			o.update(this);
		}
	}
}

