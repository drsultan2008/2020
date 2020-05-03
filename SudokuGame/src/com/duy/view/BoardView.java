package com.duy.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class BoardView extends JFrame {
	
	private JPanel mainPanel;
	private JPanel head;
	private JPanel body;
	private JPanel foot;
	private JTextField[][] board;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu aboutMenu;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem infoGame;
	
	public BoardView() {
		new JFrame("Example UI");
		setSize(300,400);
		setLocation(100,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Fixed layout
		setResizable(false);
		
		init();
	}
	
	private void init() {
		mainPanel = new JPanel();
		head = new JPanel();
		body = new JPanel();
		foot = new JPanel();
		board = new JTextField[9][9];
		
		setContentPane(mainPanel);
		
		mainPanel.setLayout(new BorderLayout());
		
		mainPanel.add(head,BorderLayout.NORTH);
		mainPanel.add(foot,BorderLayout.SOUTH);
		mainPanel.add(body,BorderLayout.CENTER);
		
		setHead();
		setBody();
		setFoot();
		
	}
	
	private void setHead() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem infoGame = new JMenuItem("Info");
			
		fileMenu.add(open);
		fileMenu.add(save);
		
		aboutMenu.add(infoGame);
		
		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		
		head.setLayout(new BorderLayout());
		head.add(menuBar,BorderLayout.NORTH);
	}
	
	private void setBody() {
		body.setLayout(new GridLayout(0,9));
		
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				board[i][j] = new JTextField(Integer.toString(i)+Integer.toString(j));
				board[i][j].setHorizontalAlignment(JTextField.CENTER);
				body.add(board[i][j]);
			}
		}
		
	}
	
	public void setTextField(int i, int j) {
		board[i][j].setText("1");
	}
	
	public void setBoard(String[][] map) {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				board[i][j].setText(map[i][j]);
			}
		}
	}
	
	public String[][] getBoard() {
		String[][] map = new String[9][9];
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				map[i][j] = board[i][j].getText();
			}
		}
		return map;
	}
	
	private void setFoot() {
		JLabel msg = new JLabel("Status bar");
		foot.add(msg);
	}
	
	
//	public static void main(String args[]) {
//		BoardView jframe = new BoardView();
//		jframe.setVisible(true);
//	}
}
