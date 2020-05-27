package com.duy.view;

import java.awt.Graphics;

import javax.swing.JLabel;

public interface  Piece{
	public JLabel getLabel();
	public void setBackground();
	public void paintComponent(Graphics g);
}
