package com.duy.entity;

import java.net.URL;
import java.util.List;

import com.duy.utils.Constants;

public class Empty implements Element {

	private Point x;
	private URL url = getClass().getResource("/com/duy/images/");
	
	public Empty(Point x) {
		this.x = x;
	}
	
	@Override
	public List<Element> movesPossible(Element[][] boardData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point corr() {
		// TODO Auto-generated method stub
		return x;
	}

	public void setCorr(Point x) {
		this.x = x;
	}

}
