package com.duy.operatingsystem.pagereplacement;

public class Tiny {
	private int i;
	private int pos;

	public Tiny(int i, int pos) {
		super();
		this.i = i;
		this.pos = pos;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	@Override
	public String toString() {
		return "Tiny [i=" + i + ", pos=" + pos + "]";
	}
	
}
