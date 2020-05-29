package com.duy.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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
			controller.undo();
		}
		
		if (e.getSource() == redo) {
			controller.redo();
		}
		
		if (e.getSource() == home) {
			JOptionPane pane = new JOptionPane();
			int input = pane.showConfirmDialog(null, "Lưu màn chơi trước khi trở về trang chủ ?","Cảnh báo",JOptionPane.YES_NO_OPTION);
			// Yes - 0 | No -1
			if (input == 0) {
				SavePanel savePanel = new SavePanel(controller);
//				JOptionPane Optionpane =new JOptionPane();
//				
//				JDialog dialog = pane.createDialog(savePanel, "?");
//				dialog.setVisible(true);
				
				JOptionPane.showOptionDialog(null, savePanel, "Save Chess", JOptionPane.DEFAULT_OPTION, JOptionPane.UNDEFINED_CONDITION, null,new Object[] {}, null);
//				JOptionPane.showMessageDialog(null, savePanel,"Save Chess",JOptionPane.UNDEFINED_CONDITION);
//				System.out.println("Input = 0");
//				SavePanel savePanel = new SavePanel(controller);
//				JDialog dialog = new JDialog();
//				dialog.setVisible(true);
//				dialog.add(savePanel);
//				dialog.setSize(new Dimension(300,300));
//				dialog.setLocation(200, 200);
//				
//				dialog.setDefaultCloseOperation(dialog.DO_NOTHING_ON_CLOSE);
				controller.showHome();
			}
			else {
				controller.showHome();
			}
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
