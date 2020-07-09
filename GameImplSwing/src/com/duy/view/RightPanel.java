package com.duy.view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.duy.utils.Constants;

public class RightPanel extends JPanel {
	public RightPanel() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon(Constants.url+"/src/com/duy/images/menuBackground.png").getImage(), 0, 0,getWidth(),getHeight(),this);
		
	}
}
