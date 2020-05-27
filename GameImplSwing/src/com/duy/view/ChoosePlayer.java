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

public class ChoosePlayer extends JPanel implements MouseListener {

	private JLabel onePlayer;
	private JLabel twoPlayer;
	private JLabel luatChoi;
	private Icon iconOdd;
	private GameController controller;

	public ChoosePlayer(GameController controller) {
		this.controller = controller;
		onePlayer = new JLabel();
		twoPlayer = new JLabel();
		luatChoi = new JLabel();

		GridBagLayout gridBag = new GridBagLayout();
		setLayout(gridBag);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 80;

		add(onePlayer, c);
		add(twoPlayer, c);
		add(luatChoi, c);
		init();
	}

	private void init() {
		Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/1NguoiChoi.png").getImage()
				.getScaledInstance(301, 85, Image.SCALE_SMOOTH);
		ImageIcon img = new ImageIcon(image);
		onePlayer.setIcon(img);

		image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/2NguoiChoi.png").getImage()
				.getScaledInstance(301, 85, Image.SCALE_SMOOTH);
		img = new ImageIcon(image);
		twoPlayer.setIcon(img);

		image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/luatChoi.png").getImage()
				.getScaledInstance(301, 85, Image.SCALE_SMOOTH);
		img = new ImageIcon(image);
		luatChoi.setIcon(img);
		
		onePlayer.addMouseListener(this);
		twoPlayer.addMouseListener(this);
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
		if (e.getSource() == onePlayer) {
			controller.setOnePlayer();
		}
		
		if (e.getSource() == twoPlayer) {
			controller.setTwoPlayer();
		}
		
		if (e.getSource() == luatChoi) {
			controller.showLegal();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == onePlayer) {
			iconOdd = onePlayer.getIcon();
			Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/1NguoiChoi.png").getImage().getScaledInstance(271,77, Image.SCALE_SMOOTH);
			ImageIcon img = new ImageIcon(image);
			onePlayer.setIcon(img);
		}

		if (e.getSource() == twoPlayer) {
			iconOdd = twoPlayer.getIcon();
			Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/1NguoiChoi.png").getImage().getScaledInstance(271,77, Image.SCALE_SMOOTH);
			ImageIcon img = new ImageIcon(image);
			twoPlayer.setIcon(img);
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
		if (e.getSource() == onePlayer) {
			onePlayer.setIcon(iconOdd);
		}

		if (e.getSource() == twoPlayer) {
			twoPlayer.setIcon(iconOdd);
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
