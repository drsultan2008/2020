package com.duy.view;

import java.awt.BorderLayout;
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
	private JMenuBar menuBar;
	private JMenu about;
	private JMenu help;
	private JMenu open;
	private JButton[][] board;
	private JButton home;
	private JButton textTurn;
	private JButton turn;
	private JButton undo;
	private JButton redo;
	private Piece[][] piece;
	
	public PlayPanel() {
		setLayout(new BorderLayout());
		init();
	}

	private void init() {
		initBody();
		body = new JPanel();
	}

	private void initHead() {
		menuBar = new JMenuBar();
		about = new JMenu("About");
		help = new JMenu("Help");
		open = new JMenu("Open");

		menuBar.add(about);
		menuBar.add(help);
		menuBar.add(open);

		head.add(menuBar);
	}

	private void initBody() {
		GridLayout gridLayout = new GridLayout(7,5);
		setLayout(gridLayout);
		
		board = new JButton[5][7];
		piece = new Piece[5][7];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				piece[i][j] = new PieceTrongSuot();
				add(piece[i][j].getLabel());
			}
		}

	}

	private void initFoot() {
		foot.setLayout(new GridLayout(1, 5));

		home = new JButton();
		textTurn = new JButton();
		turn = new JButton();
		undo = new JButton();
		redo = new JButton();

		foot.add(home);
		foot.add(textTurn);
		foot.add(turn);
		foot.add(undo);
		foot.add(redo);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/board03.jpg").getImage(), 0, 0,getWidth(),getHeight(),this);
		
	}
}
