package com.duy.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Help extends JFrame{
	private JPanel main = new JPanel(new BorderLayout());
	private JLabel status = new JLabel();
	private JPanel center1 = new JPanel(new BorderLayout());
	private JPanel center2 = new JPanel(new GridLayout(2,2));
	private JPanel south2 = new JPanel();
	private JButton submit = new JButton("Ok");
	private JLabel rLb = new JLabel("Row:");
	private JTextField rTf = new JTextField();
	private JLabel cLb = new JLabel("Col:");
	private JTextField cTf = new JTextField();
	
	public Help() {
		south2.add(submit);
		
	}
	
	public static void main(String args[]) {
		System.out.println("?");
		Help help =new Help();
		help.setVisible(true);
	}
}
