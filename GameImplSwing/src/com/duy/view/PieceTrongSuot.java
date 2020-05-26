package com.duy.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.duy.utils.Constants;

public class PieceTrongSuot extends JLabel implements Piece{
	public PieceTrongSuot() {
		setPreferredSize( new Dimension(Constants.squareSize,Constants.squareSize));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/Hum02.png").getImage(),0,0,Constants.squareSize,Constants.squareSize,null);
		
	}

	@Override
	public JLabel getLabel() {
		return this;
	}
}
