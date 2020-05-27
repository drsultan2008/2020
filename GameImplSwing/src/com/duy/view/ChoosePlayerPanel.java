package com.duy.view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoosePlayerPanel extendsAa JPanel {
	
	private JLabel chonHum;
	private JLabel chonTom;
	private JLabel luatChoi;
	private JLabel blank;
	
	public ChoosePlayerPanel(){
		chonHum = new JLabel();
		chonTom = new JLabel();
		luatChoi = new JLabel();
		blank = new JLabel();
		
		add(chonHum);
		add(chonTom);
		add(luatChoi);
		init();
	}
	
	private void init() {
		Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/chonHum.png").getImage().getScaledInstance(301,85, Image.SCALE_SMOOTH);
		ImageIcon img = new ImageIcon(image);
		chonHum.setIcon(img);
		
		image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/chonTom.png").getImage().getScaledInstance(301,85, Image.SCALE_SMOOTH);
		img = new ImageIcon(image);
		chonTom.setIcon(img);
		
		image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/luatChoi.png").getImage().getScaledInstance(301,85, Image.SCALE_SMOOTH);
		img = new ImageIcon(image);
		luatChoi.setIcon(img);
		
		image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/blank.png").getImage().getScaledInstance(301, 85, Image.SCALE_SMOOTH);
		img = new ImageIcon(image);
		blank.setIcon(img);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/menuBackground.jpg").getImage(), 0, 0,getWidth(),getHeight(),this);
		
	}
}

