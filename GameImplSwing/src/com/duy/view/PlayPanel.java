package com.duy.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayPanel extends JPanel implements MouseListener{
	private JPanel head;
	private JPanel body;
	private JPanel foot;
	private JPanel main;
	private JButton[][] board;
	private JLabel[][] piece;
	private Icon icon;
	
	public PlayPanel() {
		setLayout(new BorderLayout());
		init();
	}
	

	private void init() {
		initBody();
		body = new JPanel();
	}

	private void initBody() {
		GridLayout gridLayout = new GridLayout(7,5,50,60);
		setLayout(gridLayout);
		
		piece = new JLabel[7][5];

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				if (i==0 && j==0 || i==0 && j==1|| i==1 && j==0 || j==3 && i==0 || j==4 && i==0 || j==4 && i==1 ){
					piece[i][j] = new PieceBlank();
				}
				else {
					piece[i][j] = new PieceTrongSuot();
				}
				add(piece[i][j]);
				piece[i][j].addMouseListener(this);
			}
		}
		
		Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/Hum02.png").getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);
		ImageIcon img = new ImageIcon(image);
		piece[2][3].setIcon(img);
		this.updateUI();
	}
	
	public void update(String[][] map) {
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/board.jpg").getImage(), 0, 0,getWidth(),getHeight(),this);
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX());
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				if (e.getSource() == piece[i][j]) {
					icon = piece[i][j].getIcon();
					Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/Hum02.png").getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);
					ImageIcon img = new ImageIcon(image);
					piece[i][j].setIcon(img);
				}
			}
		}
	}


	@Override
	public void mouseExited(MouseEvent e) {
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				if (e.getSource() == piece[i][j]) {
					piece[i][j].setIcon(icon);
				}
			}
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e.getX());
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}