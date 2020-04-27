package JavaCoreThayPhuc.Week10;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Jframe extends JFrame {
	

	public Jframe(){
		new JFrame("Example UI");
		setSize(300,400);
		setLocation(100,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Fixed layout
		setResizable(false);
		
		JPanel mainPanel = new JPanel();
		setContentPane(mainPanel);
		
		JButton bt1 = new JButton("Submit 1");
		JButton bt2 = new JButton("Submit 2");
		JButton bt3 = new JButton("Submit 3");
		JButton bt4 = new JButton("Submit 4");
		JButton bt5 = new JButton("Submit 5");
		
		mainPanel.setLayout(new BorderLayout());
		
		mainPanel.add(bt1,BorderLayout.WEST);
		mainPanel.add(bt2,BorderLayout.EAST);
		mainPanel.add(bt3,BorderLayout.NORTH);
		mainPanel.add(bt4,BorderLayout.SOUTH);
		
		JPanel mainPanel2 = new JPanel();
		mainPanel.add(mainPanel2,BorderLayout.CENTER);
//		mainPanel2.add(bt1,BorderLayout.WEST);
//		mainPanel2.add(bt2,BorderLayout.EAST);
//		mainPanel2.add(bt3,BorderLayout.NORTH);
//		mainPanel2.add(bt4,BorderLayout.SOUTH);
	}
	

}
