package com.duy.entity;

import java.net.URL;

import com.duy.utils.Constants;

import javafx.scene.image.Image;

public class Hum implements Element {
	
	private Point x;
	private URL url = getClass().getResource("/com/duy/images/");
	private Image image = new Image(url+"Hum02.png",Constants.squareSize,Constants.squareSize,true,true);
	
	public Hum(Point x) {
		this.x = x;
	}
	
	@Override
	public Element[] movesPossible() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point corr() {
		return x;
	}

	@Override
	public Image getImage() {
		return image;
	}

}
