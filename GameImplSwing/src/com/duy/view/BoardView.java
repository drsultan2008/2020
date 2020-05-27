package com.duy.view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.duy.utils.Constants;

public class BoardView extends JFrame implements MouseListener{
	private PlayPanel playPanel;
	private MenuPanel menuPanel;
	private TaskBarPanel taskBarPanel;
	private LeftPanel leftPanel;
	private RightPanel rightPanel;
	private ChoosePlayerPanel choosePlayerPanel;
	
	public BoardView() {
		new JFrame("Chess");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		getContentPane().removeAll();
		
		choosePlayerPanel = new ChoosePlayerPanel();
		setLayout(new BorderLayout());
		add(menuPanel,BorderLayout.NORTH);
		add(choosePlayerPanel,BorderLayout.CENTER);
		add(taskBarPanel,BorderLayout.SOUTH);
		add(leftPanel,BorderLayout.WEST);
		add(rightPanel,BorderLayout.EAST);
		
	}
	
	
	
	public static void main(String args[]) {
		BoardView boardView = new BoardView();
		boardView.setVisible(true);
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
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
