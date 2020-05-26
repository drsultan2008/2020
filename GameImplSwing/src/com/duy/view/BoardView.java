package com.duy.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

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
	private MenuPanel menuPanel;
	private TaskBarPanel taskBarPanel;
	private LeftPanel leftPanel;
	private RightPanel rightPanel;
	
	public BoardView() {
		new JFrame("Chess");
		playPanel = new PlayPanel();
		menuPanel = new MenuPanel();
		taskBarPanel = new TaskBarPanel();
		leftPanel = new LeftPanel();
		rightPanel = new RightPanel();
		
		setSize(Constants.maxWidth,Constants.maxHeight);
		setLocation(100,200);
//		setContentPane(new JLabel(new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/board03.jpg")));
		setLayout(new BorderLayout());
		add(menuPanel,BorderLayout.NORTH);
		add(playPanel,BorderLayout.CENTER);
		add(taskBarPanel,BorderLayout.SOUTH);
		add(leftPanel,BorderLayout.WEST);
		add(rightPanel,BorderLayout.EAST);
	}
	
	
	
	public static void main(String args[]) {
		BoardView boardView = new BoardView();
		boardView.setVisible(true);
	}
}
