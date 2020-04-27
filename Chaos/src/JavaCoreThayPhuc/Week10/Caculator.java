package JavaCoreThayPhuc.Week10;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Caculator extends JFrame {
	public Caculator(){
		setSize(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
	}
	
	private void init() {
		JPanel mainPanel = new JPanel();
		JPanel bodyPanel = new JPanel();
		JPanel footPanel = new JPanel();
		
		mainPanel.setLayout(new BorderLayout());
		bodyPanel.setLayout(new GridLayout(3,2));
		
		JLabel lb1 = new JLabel("First Num: ");
		JLabel lb2 = new JLabel("Seconde Num: ");
		JLabel lb3 = new JLabel("Res");
		
		JTextField tf1 = new JTextField();
		JTextField tf2 = new JTextField();
		JTextField tf3 = new JTextField();
		
		JButton btn1 = new JButton("+");
		JButton btn2 = new JButton("-");
		JButton btn3 = new JButton("*");
		JButton btn4 = new JButton("/");
		
	}
}
