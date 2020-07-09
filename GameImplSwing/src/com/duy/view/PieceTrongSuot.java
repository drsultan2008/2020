package com.duy.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.duy.utils.Constants;

public class PieceTrongSuot extends JLabel implements Piece{
	private String url;
	
	public PieceTrongSuot() {
		setPreferredSize( new Dimension(Constants.squareSize,Constants.squareSize));
		url = Constants.url+ "/src/com/duy/images/TrongSuot.png";
	}
	
	@Override
	public void setBackground() {
		url = Constants.url+"/src/com/duy/images/Hum01.png";
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon(url).getImage(),0,0,getWidth(),getHeight(),null);
		
	}

	@Override
	public JLabel getLabel() {
		return this;
	}
	
}
