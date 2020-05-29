package com.duy.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.duy.DAO.ChessDAO;
import com.duy.DAO.ChessDAOImpl;
import com.duy.controller.GameController;
import com.duy.entity.Board;
import com.duy.entity.User;

public class MenuPanel extends JPanel implements ActionListener,MouseListener{
	private JMenuBar menuBar;
	private JMenu about;
	private JMenu help;
	private JMenu open;
	private JMenuItem info;
	private JMenuItem version;
	private GameController controller;
	
	MenuPanel(GameController controller){
		this.controller = controller;
		initHead();
	}
	
	private void initHead() {
		menuBar = new JMenuBar();
		about = new JMenu("About");
		help = new JMenu("Help");
		open = new JMenu("Open");
		info = new JMenuItem("Info");
		version = new JMenuItem("Version");

		about.add(info);
		about.add(version);
		
		menuBar.add(about);
		menuBar.add(help);
		menuBar.add(open);

		add(menuBar);
		
		about.addActionListener(this);
		help.addActionListener(this);
		open.addActionListener(this);
		info.addActionListener(this);
		version.addActionListener(this);
		
		menuBar.addMouseListener(this);
		about.addMouseListener(this);
		help.addMouseListener(this);
		open.addMouseListener(this);
		info.addMouseListener(this);
		version.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == about) {
//			System.out.println("About");
		}
		
		if (e.getSource() == info) {
//			System.out.println("Info");
			JOptionPane.showMessageDialog(null, "Cờ Hùm Dân Gian, view code via my Github!", "@iamthankyou", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (e.getSource() == help) {
//			System.out.println("Help");
		}
		
		if (e.getSource() == version) {
//			System.out.println("Version");
			JOptionPane.showMessageDialog(null, "Ver 1.0.1", "Version", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (e.getSource() == open) {
//			System.out.println("Open");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == about) {
//			System.out.println("About");
		}
		
		if (e.getSource() == info) {
//			System.out.println("Info");
		}
		
		if (e.getSource() == help) {
//			System.out.println("Help");
			controller.showLegal();
		}
		
		if (e.getSource() == version) {
//			System.out.println("Version");
		}
		
		if (e.getSource() == open) {
			String userName = JOptionPane.showInputDialog("Nhập vào username của bạn");
			
			if (userName.equals("")) {
				System.out.println("Username is null");
			}
			else {
				System.out.println("Open");
				ChessDAO chessDAO = new ChessDAOImpl();
				User theUser = chessDAO.getUser(userName);
				System.out.println(theUser);
				
				if (theUser!=null) {
					List<Board> boards = chessDAO.getBoards(theUser);
					
					for (Board i:boards) {
						System.out.println(i.getData());
					}
					
					OpenPanel openPanel = new OpenPanel(controller,boards);
					JOptionPane.showOptionDialog(null, openPanel, "Save Chess", JOptionPane.DEFAULT_OPTION, JOptionPane.UNDEFINED_CONDITION, null,new Object[] {}, null);
				}
				
				

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
