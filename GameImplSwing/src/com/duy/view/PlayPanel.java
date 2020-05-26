package com.duy.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class PlayPanel extends JPanel {
	private JPanel head;
	private JPanel body;
	private JPanel foot;
	private JPanel main;
	private JButton[][] board;
	private Piece[][] piece;
	
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
		
		piece = new Piece[7][5];

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				if (i==0 && j==0 || i==0 && j==1|| i==1 && j==0 || j==3 && i==0 || j==4 && i==0 || j==4 && i==1 ){
					piece[i][j] = new PieceBlank();
				}
				else {
					piece[i][j] = new PieceTrongSuot();
				}
				add(piece[i][j].getLabel());
			}
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/board.jpg").getImage(), 0, 0,getWidth(),getHeight(),this);
		
	}
}
