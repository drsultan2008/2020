package com.duy.entity;

import javafx.scene.image.Image;

public interface Element {
	public Element[] movesPossible();
	public Point corr();
	Image getImage();
}
