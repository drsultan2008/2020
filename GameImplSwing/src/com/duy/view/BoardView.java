package com.duy.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import com.duy.utils.Constants;

public class BoardView extends JFrame {
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
	
	public BoardView() {
		new JFrame("Chess");
		setSize(Constants.maxWidth,Constants.maxHeight);
		setLocation(100,200);
		init();
	}
	
	private void init() {
		main = new JPanel();
		head = new JPanel();
		foot = new JPanel();
		body = new JPanel();
		
		add(main);
		
		main.setLayout(new BorderLayout());
		main.add(head,BorderLayout.EAST);
		main.add(body,BorderLayout.AFTER_LAST_LINE);
//		main.add(foot,BorderLayout.WEST);
		initHead();
		initBody();
		initFoot();
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
		body.setLayout(new GridLayout(7,5));
		
		board = new JButton[5][7];
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<7; j++) {
				board[i][j] = new JButton();
				body.add(board[i][j]);
				board[i][j].setPreferredSize(new Dimension(Constants.squareSize,Constants.squareSize));
				board[i][j].setBorder(BorderFactory.createEmptyBorder(0,20,20,20));
			}
		}
		
	}
	
	private void initFoot() {
		foot.setLayout(new GridLayout(1,5));
		
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
	
	public static void main(String args[]) {
		BoardView boardView = new BoardView();
		boardView.setVisible(true);
	}
}
