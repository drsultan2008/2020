package com.duy.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoosePlayerPanel extends JPanel implements MouseListener {

	private JLabel chonHum;
	private JLabel chonTom;
	private JLabel luatChoi;
	private Icon iconOdd;

	public ChoosePlayerPanel() {
		chonHum = new JLabel();
		chonTom = new JLabel();
		luatChoi = new JLabel();

//		add(body,"Center");
//		body.setHorizontalAlignment(JLabel.CENTER);
//		body.setVerticalAlignment(JLabel.CENTER);
		GridBagLayout gridBag = new GridBagLayout();
		setLayout(gridBag);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 80;

		add(chonHum, c);
		add(chonTom, c);
		add(luatChoi, c);
		init();
	}

	private void init() {
		Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/chonHum.png").getImage()
				.getScaledInstance(301, 85, Image.SCALE_SMOOTH);
		ImageIcon img = new ImageIcon(image);
		chonHum.setIcon(img);

		image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/chonTom.png").getImage()
				.getScaledInstance(301, 85, Image.SCALE_SMOOTH);
		img = new ImageIcon(image);
		chonTom.setIcon(img);

		image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/luatChoi.png").getImage()
				.getScaledInstance(301, 85, Image.SCALE_SMOOTH);
		img = new ImageIcon(image);
		luatChoi.setIcon(img);
		
		chonHum.addMouseListener(this);
		chonTom.addMouseListener(this);
		luatChoi.addMouseListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/menuBackground.jpg").getImage(), 0,
				0, getWidth(), getHeight(), this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == chonHum) {
			iconOdd = chonHum.getIcon();
			Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/chonHum.png").getImage().getScaledInstance(271,77, Image.SCALE_SMOOTH);
			ImageIcon img = new ImageIcon(image);
			chonHum.setIcon(img);
		}

		if (e.getSource() == chonTom) {
			iconOdd = chonTom.getIcon();
			Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/chonTom.png").getImage().getScaledInstance(271,77, Image.SCALE_SMOOTH);
			ImageIcon img = new ImageIcon(image);
			chonTom.setIcon(img);
		}

		if (e.getSource() == luatChoi) {
			iconOdd = luatChoi.getIcon();
			Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/luatChoi.png").getImage().getScaledInstance(271,77, Image.SCALE_SMOOTH);
			ImageIcon img = new ImageIcon(image);
			luatChoi.setIcon(img);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == chonHum) {
			chonHum.setIcon(iconOdd);
		}

		if (e.getSource() == chonTom) {
			chonTom.setIcon(iconOdd);
		}

		if (e.getSource() == luatChoi) {
			luatChoi.setIcon(iconOdd);
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
