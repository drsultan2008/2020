package com.duy.entity;

import java.net.URL;

import com.duy.utils.Constants;

import javafx.scene.image.Image;

public class Stop implements Element {

	private URL url = getClass().getResource("/com/duy/images/");
	private Image image = new Image(url+"trongSuot.png",Constants.squareSize,Constants.squareSize,true,true);
	
	@Override
	public Element[] movesPossible() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point corr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getImage() {
		return image;
	}

}
