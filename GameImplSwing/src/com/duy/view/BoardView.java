package com.duy.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import com.duy.utils.Constants;

public class BoardView extends JFrame {
	private PlayPanel playPanel;
	
	public BoardView() {
		new JFrame("Chess");
		playPanel = new PlayPanel();
		setSize(Constants.maxWidth,Constants.maxHeight);
		setLocation(100,200);
//		setContentPane(new JLabel(new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/board03.jpg")));
		add(playPanel);
	}
	
	
	
	public static void main(String args[]) {
		BoardView boardView = new BoardView();
		boardView.setVisible(true);
	}
}
