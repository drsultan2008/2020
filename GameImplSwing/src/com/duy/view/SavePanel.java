package com.duy.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.duy.DAO.ChessDAO;
import com.duy.DAO.ChessDAOImpl;
import com.duy.entity.User;

public class SavePanel extends JPanel implements MouseListener{
	private JTextField textFieldName;
	private JLabel labelName;
	private JButton submit;
	
	public SavePanel() {
		textFieldName = new JTextField();
		labelName = new JLabel("Nhập tên tài khoản: ");
		submit = new JButton("Lưu");
		init();
	}
	
	private void init() {
		GridBagLayout gridBag = new GridBagLayout();
		setLayout(gridBag);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 80;
		c.ipadx = 20;
		c.ipady = 20;
		c.insets = new Insets(10,10,10,10);
		
		submit.setPreferredSize(new Dimension(200,30));
		textFieldName.setPreferredSize(new Dimension(200,30));
		add(labelName,c);
		add(textFieldName,c);
		add(submit,c);
		
		submit.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == submit) {
			System.out.println("Click Save username: ");
			// Save to database
			System.out.print(textFieldName.getText());
			ChessDAO chessDAO = new ChessDAOImpl();
			User user = new User(textFieldName.getText());
			chessDAO.addUserName(user);
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
