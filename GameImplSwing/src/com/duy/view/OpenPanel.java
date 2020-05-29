package com.duy.view;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.duy.controller.GameController;
import com.duy.entity.Board;

public class OpenPanel extends JPanel implements MouseListener{
	private GameController controller;
	private List<Board> maps;
	private List<JButton> listButton;
	
	public OpenPanel(GameController controller,List<Board> maps) {
		this.controller = controller;
		this.maps = maps;
		
		listButton = new ArrayList<>();
		init();
	}
	
	private void init() {
		setLayout(new GridLayout(5,5));
		int c = 0;
		
		for (Board i:maps) {
			listButton.add(new JButton("Game "+Integer.toString(++c)));
		}

		for (JButton i:listButton) {
			add(i);
			i.addMouseListener(this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i=0; i<listButton.size(); i++) {
			if (e.getSource() == listButton.get(i)) {
				System.out.println("Value i: " + i);
				System.out.println(maps.get(i));
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
