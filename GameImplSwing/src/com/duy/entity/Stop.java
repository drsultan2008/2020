package com.duy.entity;

import java.net.URL;
import java.util.List;

import com.duy.utils.Constants;

public class Stop implements Element {

	private URL url = getClass().getResource("/com/duy/images/");
	private Point x;
	
	public Stop(Point x) {
		this.x = x;
	}
	
	@Override
	public List<Element> movesPossible(Element[][] boardData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point corr() {
		return x;
	}

	public void setCorr(Point x) {
		this.x = x;
	}

}
