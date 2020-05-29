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
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.duy.DAO.ChessDAO;
import com.duy.DAO.ChessDAOImpl;
import com.duy.controller.GameController;
import com.duy.entity.BTom;
import com.duy.entity.Board;
import com.duy.entity.Element;
import com.duy.entity.Empty;
import com.duy.entity.Hum;
import com.duy.entity.Tom;
import com.duy.entity.User;

public class SavePanel extends JPanel implements MouseListener {
	private JTextField textFieldName;
	private JLabel labelName;
	private JButton submit;
	private GameController controller;
	private static JProgressBar prog;

	public SavePanel(GameController controller) {
		this.controller = controller;

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
		c.insets = new Insets(10, 10, 10, 10);

		submit.setPreferredSize(new Dimension(200, 30));
		textFieldName.setPreferredSize(new Dimension(200, 30));
		add(labelName, c);
		add(textFieldName, c);
		add(submit, c);

		submit.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == submit) {
			prog = new JProgressBar();
			prog.setValue(0);
			prog.setStringPainted(true);

			add(prog);
			
			labelName.setText("Đã lưu");
			remove(submit);
			remove(textFieldName);
			SwingUtilities.updateComponentTreeUI(this);
			
			int c = 0;
			
			try {
				while (c <= 100) {
					prog.setValue(c + 10);
					Thread.sleep(1000);
					c+=20;
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			// Save to database
			System.out.print(textFieldName.getText());
			ChessDAO chessDAO = new ChessDAOImpl();
			User user = new User(textFieldName.getText());
			chessDAO.addUserName(user);

			Element[][] map = controller.getMap();
			StringBuilder stringBuiler = new StringBuilder();

			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i][j] instanceof Hum) {
//						System.out.print("H");
						stringBuiler.append('H');
					} else if (map[i][j] instanceof Tom) {
//						System.out.print("T");
						stringBuiler.append('T');
					} else if (map[i][j] instanceof BTom) {
//						System.out.print("B");
						stringBuiler.append('B');
					} else if (map[i][j] instanceof Empty) {
//						System.out.print("O");
						stringBuiler.append('O');
					} else {
//						System.out.print("X");
						stringBuiler.append('X');
					}
				}
//				System.out.println();;
			}

			if (controller.isOnePlayer()) {
				stringBuiler.append('A');
			} else {
				stringBuiler.append('M');
			}

			if (controller.getAITurn() == -1) {
				stringBuiler.append('H');
			} else {
				stringBuiler.append('T');
			}

			System.out.println("The map" + stringBuiler.toString());
			chessDAO.addBoard(new Board(stringBuiler.toString()), user);


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
