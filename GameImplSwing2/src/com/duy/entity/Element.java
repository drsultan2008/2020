package com.duy.entity;

import java.util.List;

public interface Element {
	public List<Element> movesPossible(Element[][] boardData);
	public Point corr();
	public void setCorr(Point x);
}
