package com.duy.view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LeftPanel extends JPanel {
	public LeftPanel() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/menuBackground.png").getImage(), 0, 0,getWidth(),getHeight(),this);
		
	}
}
