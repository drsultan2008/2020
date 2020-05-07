package com.duy.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class CaculatorGUI extends JFrame {
	private JPanel mainPanel;
	private JPanel display;
	private JPanel behavior;

	private JButton[][] buttons;
	private JLabel typing;
	private JLabel result;

	public CaculatorGUI() {
		new JFrame("Caculator");
		setSize(300, 400);
		setLocation(100, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Fixed layout
		setResizable(false);

		init();
	}

	private void init() {
		mainPanel = new JPanel();
		display = new JPanel();
		behavior = new JPanel();

		buttons = new JButton[5][4];
		typing = new JLabel("4+2=");
		result = new JLabel("6");

		setContentPane(mainPanel);
		mainPanel.setLayout(new BorderLayout());

		mainPanel.add(display, BorderLayout.NORTH);
		display.setPreferredSize(new Dimension(200, 100));

		mainPanel.add(behavior, BorderLayout.CENTER);

		setDisplay();
		setBehavior();
	}

	private void setDisplay() {
		display.setLayout(new BorderLayout());
		display.setBackground(Color.WHITE);
		JPanel typ = new JPanel();
		typ.setBackground(Color.WHITE);
		typ.setLayout(new BorderLayout());
		Border border = typ.getBorder();
		Border margin = new EmptyBorder(25, 10, 10, 10);
		typ.setBorder(new CompoundBorder(border, margin));

		border = result.getBorder();
		margin = new EmptyBorder(10, 10, 10, 10);
		result.setBorder(new CompoundBorder(border, margin));

		display.add(typ, BorderLayout.NORTH);
		typ.add(typing, BorderLayout.EAST);
		display.add(result, BorderLayout.EAST);

		result.setFont(new Font("Serif", Font.PLAIN, 30));

	}

	private void setBehavior() {
		behavior.setLayout(new GridLayout(0, 4));

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				buttons[i][j] = new JButton(Integer.toString(i) + "," + Integer.toString(j));
				behavior.add(buttons[i][j]);
				buttons[i][j].setBackground(Color.white);
				buttons[i][j].setForeground(Color.GRAY);
				buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.gray));
			}
		}

		buttons[0][0].setText("CE");
		buttons[0][1].setText("C");
		buttons[0][2].setText("<<");
		buttons[0][3].setText("÷");
		buttons[1][0].setText("7");
		buttons[1][1].setText("8");
		buttons[1][2].setText("9");
		buttons[1][3].setText("x");
		buttons[2][0].setText("4");
		buttons[2][1].setText("5");
		buttons[2][2].setText("6");
		buttons[2][3].setText("-");
		buttons[3][0].setText("1");
		buttons[3][1].setText("2");
		buttons[3][2].setText("3");
		buttons[3][3].setText("+");
		buttons[4][0].setText("Ans");
		buttons[4][1].setText("0");
		buttons[4][2].setText(".");
		buttons[4][3].setText("=");
	}

	public static void main(String args[]) {
		CaculatorGUI caculatorGUI = new CaculatorGUI();
		caculatorGUI.setVisible(true);
	}

}
