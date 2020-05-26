package com.duy.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	private JMenuBar menuBar;
	private JMenu about;
	private JMenu help;
	private JMenu open;
	
	MenuPanel(){
		initHead();
	}
	
	private void initHead() {
		menuBar = new JMenuBar();
		about = new JMenu("About");
		help = new JMenu("Help");
		open = new JMenu("Open");

		menuBar.add(about);
		menuBar.add(help);
		menuBar.add(open);

		add(menuBar);
	}
}
