package com.duy.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TaskBarPanel extends JPanel {
	private JButton home;
	private JButton textTurn;
	private JButton turn;
	private JButton undo;
	private JButton redo;
	
	public TaskBarPanel() {
		initFoot();
	}
	
	private void initFoot() {
		setLayout(new GridLayout(1, 5));

		home = new JButton();
		textTurn = new JButton();
		turn = new JButton();
		undo = new JButton();
		redo = new JButton();
		
		home.setPreferredSize(new Dimension(40,40));
		add(home);
		add(textTurn);
		add(turn);
		add(undo);
		add(redo);
	}
}
