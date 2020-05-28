package com.duy.view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.duy.controller.GameController;
import com.duy.entity.BTom;
import com.duy.entity.Element;
import com.duy.entity.Empty;
import com.duy.entity.Hum;
import com.duy.entity.Point;
import com.duy.entity.Tom;
import com.duy.utils.Observable;
import com.duy.utils.Observer;
import com.duy.utils.UpdateIcon;

public class PlayPanel extends JPanel implements MouseListener,Observer,ActionListener{
	private JPanel head;
	private JPanel body;
	private JPanel foot;
	private JPanel main;
	private JButton[][] board;
	private JLabel[][] piece;
	private Icon icon;
	private List<UpdateIcon> updateIcons;
	private GameController controller;
	private Element firstClick;
	
	public PlayPanel(GameController controller) {
		this.controller = controller;
		updateIcons = new ArrayList<>();
		firstClick = null;
		
		setLayout(new BorderLayout());
		init();
	}

	private void init() {
		initBody();
		body = new JPanel();
	}

	private void initBody() {
		GridLayout gridLayout = new GridLayout(7, 5, 50, 60);
		setLayout(gridLayout);

		piece = new JLabel[7][5];

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == 0 && j == 0 || i == 0 && j == 1 || i == 1 && j == 0 || j == 3 && i == 0 || j == 4 && i == 0
						|| j == 4 && i == 1) {
					piece[i][j] = new PieceBlank();
				} else {
					piece[i][j] = new PieceTrongSuot();
				}
				add(piece[i][j]);
				piece[i][j].addMouseListener(this);
			}
		}
		
		SwingUtilities.updateComponentTreeUI(this);
		update();
		this.updateUI();
	}

	public void update() {
		Element[][] elements = controller.getMap();
		removeAll();
		GridLayout gridLayout = new GridLayout(7, 5, 50, 60);
		setLayout(gridLayout);
		System.out.println("Update");

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == 0 && j == 0 || i == 0 && j == 1 || i == 1 && j == 0 || j == 3 && i == 0 || j == 4 && i == 0
						|| j == 4 && i == 1) {
					piece[i][j] = new PieceBlank();
				}
				else if (elements[i][j] instanceof Hum) {
					piece[i][j] = new PieceHum();
				}
				else if (elements[i][j] instanceof Tom) {
					piece[i][j] = new PieceTom();
				}
				else if (elements[i][j] instanceof BTom) {
					piece[i][j] = new PieceBTom();
				}
				
				else if (elements[i][j] instanceof Empty) {
					piece[i][j] = new PieceTrongSuot();
				}
				
				add(piece[i][j]);
				piece[i][j].addMouseListener(this);
			}
		}
		SwingUtilities.updateComponentTreeUI(this);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/board.jpg").getImage(), 0, 0,
				getWidth(), getHeight(), this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		update();
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				if (e.getSource() == piece[i][j]) {
					if (firstClick == null) {
						firstClick = controller.getElement(i, j);
					}
					else {
						Point x = new Point(firstClick.corr().getX(), firstClick.corr().getY());
						Point y = new Point(i,j);
						
						if (controller.getIsHum()) {
							if (controller.getElement(x.getX(), x.getY()) instanceof Hum) {
								List<Element> list = controller.getElement(x.getX(), x.getY())
										.movesPossible(controller.getElementManager().getMap());
								
								for (Element iter:list) {
									if (iter.corr().getX() == y.getX() && iter.corr().getY()==y.getY()) {
										controller.move(x, y);
										controller.setTom();
										controller.setTurnTom();
										break;
									}
								}
							}
						}
						else {
							if (controller.getElement(x.getX(), x.getY()) instanceof Tom || controller.getElement(x.getX(), x.getY()) instanceof BTom ) {
								List<Element> list = controller.getElement(x.getX(), x.getY())
										.movesPossible(controller.getElementManager().getMap());
								
								for (Element iter:list) {
									if (iter.corr().getX() == y.getX() && iter.corr().getY()==y.getY()) {
										controller.move(x, y);
										controller.setHum();
										controller.setTurnHum();
										break;
									}
								}
							}
						}
						
						firstClick = null;
					}
				}
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				if (e.getSource() == piece[i][j]) {
					icon = piece[i][j].getIcon();
					updateIcons = new ArrayList<>();
					updateIcons.add(new UpdateIcon(icon,new Point(i,j)));
					if (controller.getIsHum()) {
						if (piece[i][j] instanceof PieceHum) {
							Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/hover.jpg")
									.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
							ImageIcon img = new ImageIcon(image);
							piece[i][j].setIcon(img);
						}
						else {
							Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/Hum02.png")
									.getImage().getScaledInstance(35,35, Image.SCALE_SMOOTH);
							ImageIcon img = new ImageIcon(image);
							piece[i][j].setIcon(img);
						}
						
					}else {
						if (piece[i][j] instanceof PieceTom) {
							Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/hover.jpg")
									.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
							ImageIcon img = new ImageIcon(image);
							piece[i][j].setIcon(img);
						}
						else {
							Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/Tot01.png")
									.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
							ImageIcon img = new ImageIcon(image);
							piece[i][j].setIcon(img);
						}
						
					}
					
					if (controller.getIsHum()) {
						if (controller.getElement(i, j) instanceof Hum) {
							List<Element> list = controller.getElement(i, j)
									.movesPossible(controller.getElementManager().getMap());
							
//							Element[][] m = controller.getElementManager().getMap();
//							for (int ii=0; ii<7; ii++) {
//								for (int jj=0; jj<5; jj++) {
//									if (m[ii][jj] instanceof Hum) {
//										System.out.print("Hum");
//									}
//									else if (m[ii][jj] instanceof BTom) {
//										System.out.print("BTom");
//									}
//									else if (m[ii][jj] instanceof Tom) {
//										System.out.print("Tom");
//									}
//									else {
//										System.out.print("XXX");
//									}
//								}
//								System.out.println();
//							}
//							
							if (list == null) {

							} else {
								for (Element iter : list) {
									if (iter instanceof Hum || iter instanceof Tom || iter instanceof BTom) {
										System.out.println("?");
										Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/hover.jpg")
												.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
										ImageIcon img = new ImageIcon(image);
										piece[iter.corr().getX()][iter.corr().getY()].setIcon(img);
									}
									else {
										Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/click.png")
												.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
										ImageIcon img = new ImageIcon(image);
										updateIcons.add(new UpdateIcon(piece[iter.corr().getX()][iter.corr().getY()].getIcon(),new Point(iter.corr().getX(),iter.corr().getY())));
										piece[iter.corr().getX()][iter.corr().getY()].setIcon(img);
									}
								}
							}
							
						}
					}
					else {
						
//						Element[][] m = controller.getElementManager().getMap();
//						for (int ii=0; ii<7; ii++) {
//							for (int jj=0; jj<5; jj++) {
//								if (m[ii][jj] instanceof Hum) {
//									System.out.print("Hum");
//								}
//								else if (m[ii][jj] instanceof BTom) {
//									System.out.print("BTom");
//								}
//								else if (m[ii][jj] instanceof Tom) {
//									System.out.print("Tom");
//								}
//								else {
//									System.out.print("XXX");
//								}
//							}
//							System.out.println();
//						}
						
						
						if (controller.getElement(i, j) instanceof Tom || controller.getElement(i, j) instanceof BTom) {
							List<Element> list = controller.getElement(i, j)
									.movesPossible(controller.getElementManager().getMap());

							if (list == null) {

							} else {
								for (Element iter : list) {
									if (iter instanceof Hum || iter instanceof Tom || iter instanceof BTom) {
										System.out.println("?");
										Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/hover.jpg")
												.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
										ImageIcon img = new ImageIcon(image);
										piece[iter.corr().getX()][iter.corr().getY()].setIcon(img);
									}
									else {
										Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/click.png")
												.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
										ImageIcon img = new ImageIcon(image);
										updateIcons.add(new UpdateIcon(piece[iter.corr().getX()][iter.corr().getY()].getIcon(),new Point(iter.corr().getX(),iter.corr().getY())));
										piece[iter.corr().getX()][iter.corr().getY()].setIcon(img);
										
									}
								}
							}
						}
					}

				}
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
//		update();
		for (UpdateIcon i:updateIcons) {
			piece[(int)i.getPoint().getX()][(int)i.getPoint().getY()].setIcon(i.getIcon());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Observable o) {
		update();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Action");
	}

}