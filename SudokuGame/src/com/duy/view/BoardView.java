package com.duy.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.duy.controller.GameController;
import com.duy.model.BoardGame;
import com.duy.model.Node;
import com.duy.utils.Constants;


public class BoardView extends JFrame implements Observer, ActionListener{
	
	private GameController gameController;
	
	private JPanel mainPanel;
	private JPanel head;
	private JPanel body;
	private JPanel foot;
	private JTextField[][] board;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu aboutMenu;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem infoGame;
	private JButton startGame;
	private JLabel msg;
	
	private Color[][] color;
	
	
	public BoardView(GameController gameController) {
		this.gameController =  gameController;
		new JFrame("Example UI");
		setSize(300,400);
		setLocation(100,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Fixed layout
		setResizable(false);
		
		init();
	}
	
	private void init() {
		mainPanel = new JPanel();
		head = new JPanel();
		body = new JPanel();
		foot = new JPanel();
		board = new JTextField[Constants.SIZE][Constants.SIZE];
		color = new Color[Constants.SIZE][Constants.SIZE];
		
		setContentPane(mainPanel);
		
		mainPanel.setLayout(new BorderLayout());
		
		mainPanel.add(head,BorderLayout.NORTH);
		mainPanel.add(foot,BorderLayout.SOUTH);
		mainPanel.add(body,BorderLayout.CENTER);
		
		setHead();
		setBody();
		setFoot();
		
	}
	
	private void setHead() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		infoGame = new JMenuItem("Info");
			
		fileMenu.add(open);
		fileMenu.add(save);
		
		aboutMenu.add(infoGame);
		
		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		
		head.setLayout(new BorderLayout());
		head.add(menuBar,BorderLayout.NORTH);
		
		open.addActionListener(this);
		save.addActionListener(this);
		infoGame.addActionListener(this);
	}
	
	private void setBody() {
		body.setLayout(new GridLayout(0,9));
		
		for (int i=0; i<Constants.SIZE; i++) {
			for (int j=0; j<Constants.SIZE; j++) {
				board[i][j] = new JTextField("");
				board[i][j].setHorizontalAlignment(JTextField.CENTER);
				body.add(board[i][j]);
				
				board[i][j].addActionListener(this);
			}
		}
		
		colorBoard();
		
	}
	
	private void subBlock(int m, int n) {
		Random random = new Random();
		Color c = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256),random.nextInt(256));
		for (int i=m,k=0; k<3; i++,k++) {
			for (int j=n,k1=0; k1<3; j++,k1++) {
				board[i][j].setBackground(c);
				color[i][j] = c;
			}
		}
	}
	
	private void subBlock2(int m, int n) {
		for (int i=m,k=0; k<3; i++,k++) {
			for (int j=n,k1=0; k1<3; j++,k1++) {
				board[i][j].setBackground(color[i][j]);
			}
		}
	}

	
	private void colorBoard() {
		for (int i=0; i<Constants.SIZE/3; i++) {
			for (int j=0; j<Constants.SIZE/3; j++) {
				subBlock(i*3,j*3);
			}
		}
	}
	
	private void defaultColor() {
		for (int i=0; i<Constants.SIZE/3; i++) {
			for (int j=0; j<Constants.SIZE/3; j++) {
				subBlock2(i*3,j*3);
			}
		}
	}
	
	
	public void setTextField(int i, int j) {
		board[i][j].setText("1");
	}
	
	public void setBoard(String[][] map) {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				board[i][j].setText(map[i][j]);
			}
		}
	}
	
	public String[][] getBoard() {
		String[][] map = new String[9][9];
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				map[i][j] = board[i][j].getText();
			}
		}
		return map;
	}
	
	private void setFoot() {
		startGame = new JButton("Start");
		msg = new JLabel("Xin chào");
		foot.setLayout(new BorderLayout());
		JPanel center = new JPanel();
		foot.add(center,BorderLayout.CENTER);
		foot.add(startGame,BorderLayout.NORTH);
		center.add(msg);
		
		startGame.addActionListener(this);
	}
	
	private void showDialog() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(Constants.path));
		
		int res = fileChooser.showOpenDialog(this);
		
		if (res == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			gameController.readData(selectedFile.getAbsolutePath());
		}
	}
	
	private void showSaveDialog() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save Game:");
		fileChooser.setCurrentDirectory(new File(Constants.path));
		
		int res = fileChooser.showSaveDialog(this);
		
		if (res == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			gameController.saveData(fileToSave.getAbsolutePath());
		}
	}
	
	private void setNode(int i, int j) {
		// Reset color
		defaultColor();
		
		gameController.setNode(i, j, new Node(i,j,board[i][j].getText().charAt(0),false));
		
		boolean row = true,col = true, block = true;
		Node node = gameController.getNode(i, j);
		
		if (node.validSudoku(gameController.getMap())) {
			showEndGame();
			System.out.println("?");
		}
		
		
		if (!node.validRow(gameController.getMap())) {
			for (int c=0; c<Constants.SIZE; c++) {
				board[i][c].setBackground(Color.red);
			}
			
			msg.setText("Lỗi Hàng/Cột rồi !");
		}
		
		if (!node.validCol(gameController.getMap())) {
			for (int r=0; r<Constants.SIZE; r++) {
				board[r][j].setBackground(Color.red);
			}
			
			msg.setText("Lỗi Hàng/Cột rồi !");
		}
		
		if (!block) {
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() == open) {
			showDialog();
		}
		
		if (event.getSource() == save) {
			showSaveDialog();
		}
		
		if (event.getSource() == startGame) {
			Random random = new Random();
			int num = random.nextInt(7);
			gameController.readData(Constants.path+"case0"+Integer.toString(num)+".txt");
		}
		
		for (int i=0; i<Constants.SIZE; i++) {
			for (int j=0; j<Constants.SIZE; j++) {
				if (event.getSource() == board[i][j]) {
					try{
						setNode(i,j);
					}
					catch(Exception e) {
						msg.setText("Có vẻ bạn chưa nhập gì cả !");
					}
				}
			}
		}
	}
	
	private void showEndGame() {
		int input = JOptionPane.showConfirmDialog(null, "Bạn thì ghê rồi ! Chơi lại ?","Winner",JOptionPane.YES_NO_OPTION);
		// Yes - 0 | No -1
		
		if (input == 0) {
			Random random = new Random();
			int num = random.nextInt(7);
			gameController.readData(Constants.path+"case0"+Integer.toString(num)+".txt");
		}
		else {
			System.exit(0);
		}
	}
	
	private void updateBoard(Node[][] map) {
		for (int i=0; i<Constants.SIZE; i++) {
			for (int j=0; j<Constants.SIZE; j++) {
				board[i][j].setEnabled(true);
				board[i][j].setText(Character.toString(map[i][j].getVal()));
				if (board[i][j].getText().equals(".")) {
					board[i][j].setText("");
				}
				board[i][j].setForeground(Color.DARK_GRAY);

				
				if (map[i][j].isFixed()) {
					board[i][j].setEnabled(false);
				}
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		updateBoard(((BoardGame) arg0).getMap());
	}
	
}
