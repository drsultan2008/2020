package com.duy.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.duy.controller.GameController;

public class TaskBarPanel extends JPanel implements MouseListener{
	private JButton home;
	private JButton textTurn;
	private JButton turn;
	private JButton undo;
	private JButton redo;
	private GameController controller;
	
	public TaskBarPanel(GameController controller) {
		this.controller = controller;
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
		add(textTurn);
		add(turn);
		add(home);
		add(undo);
		add(redo);
		
		home.addMouseListener(this);
		undo.addMouseListener(this);
		redo.addMouseListener(this);
	}
	
	public void show() {
		textTurn.setText("TURN:");
		home.setText("Home");
		undo.setText("Undo");
		redo.setText("Redo");
	}
	
	public void setTurnHum() {
		turn.setText("Hum");
	}
	
	public void setTurnTom() {
		turn.setText("Tom");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == undo) {
			
		}
		
		if (e.getSource() == redo) {
			
		}
		
		if (e.getSource() == home) {
			controller.showHome();
		}
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
