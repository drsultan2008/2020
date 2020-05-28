package com.duy.view;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.duy.controller.GameController;

public class EndGame extends JPanel implements MouseListener {
	
	private JLabel humThang;
	private JLabel tomThang;
	private JLabel choiLai;
	private Icon iconOdd;
	private GameController controller;

	public EndGame(GameController controller) {
		this.controller = controller;
		humThang = new JLabel();
		tomThang = new JLabel();
		choiLai = new JLabel();
		
		setHumThang();
		
		init();
	}

	private void init() {
		Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/humThang.png").getImage()
				.getScaledInstance(301, 85, Image.SCALE_SMOOTH);
		ImageIcon img = new ImageIcon(image);
		humThang.setIcon(img);

		image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/tomThang.png").getImage()
				.getScaledInstance(301, 85, Image.SCALE_SMOOTH);
		img = new ImageIcon(image);
		tomThang.setIcon(img);

		image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/choiLai.png").getImage()
				.getScaledInstance(301, 85, Image.SCALE_SMOOTH);
		img = new ImageIcon(image);
		choiLai.setIcon(img);
		
		humThang.addMouseListener(this);
		tomThang.addMouseListener(this);
		choiLai.addMouseListener(this);
	}
	
	public void setHumThang() {
		removeAll();
		GridBagLayout gridBag = new GridBagLayout();
		setLayout(gridBag);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 80;
		
		add(humThang,c);
		add(choiLai,c);
	}
	
	public void setTomThang() {
		removeAll();
		GridBagLayout gridBag = new GridBagLayout();
		setLayout(gridBag);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 80;
		
		add(tomThang,c);
		add(choiLai,c);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/menuBackground.jpg").getImage(), 0,
				0, getWidth(), getHeight(), this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource() == choiLai) {
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == humThang) {
			iconOdd = humThang.getIcon();
			Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/1NguoiChoi.png").getImage().getScaledInstance(271,77, Image.SCALE_SMOOTH);
			ImageIcon img = new ImageIcon(image);
			humThang.setIcon(img);
		}

		if (e.getSource() == tomThang) {
			iconOdd = tomThang.getIcon();
			Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/1NguoiChoi.png").getImage().getScaledInstance(271,77, Image.SCALE_SMOOTH);
			ImageIcon img = new ImageIcon(image);
			tomThang.setIcon(img);
		}

		if (e.getSource() == choiLai) {
			iconOdd = choiLai.getIcon();
			Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/luatChoi.png").getImage().getScaledInstance(271,77, Image.SCALE_SMOOTH);
			ImageIcon img = new ImageIcon(image);
			choiLai.setIcon(img);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == humThang) {
			humThang.setIcon(iconOdd);
		}

		if (e.getSource() == tomThang) {
			tomThang.setIcon(iconOdd);
		}

		if (e.getSource() == choiLai) {
			choiLai.setIcon(iconOdd);
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
}
