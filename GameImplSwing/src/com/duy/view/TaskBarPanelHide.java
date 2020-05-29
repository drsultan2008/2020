package com.duy.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.duy.controller.GameController;

public class TaskBarPanelHide extends JPanel implements MouseListener{
	private JButton taskBar;
	private GameController controller;
	
	public TaskBarPanelHide(GameController controller) {
		this.controller = controller;
		initFoot();
	}
	
	private void initFoot() {
		setLayout(new GridLayout(1, 1));
		
		taskBar = new JButton();
		taskBar.setPreferredSize(new Dimension(40,40));
		add(taskBar);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
