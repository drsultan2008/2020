package com.duy.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.duy.utils.Constants;

public class PieceHumScale extends JLabel implements Piece{
	public PieceHumScale() {
		setPreferredSize( new Dimension(Constants.squareSize,Constants.squareSize));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/Hum02.png").getImage(),0,0,getWidth()-5,getHeight()-5,null);
		
	}

	@Override
	public JLabel getLabel() {
		return this;
	}

	@Override
	public void setBackground() {
		// TODO Auto-generated method stub
		
	}
}
