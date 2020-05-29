package com.duy.view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.duy.controller.GameController;

public class LegalView extends JPanel implements MouseListener {

	private JLabel troVe;
	private Icon iconOdd;
	private GameController controller;

	public LegalView(GameController controller) {
		this.controller = controller;
		
		troVe = new JLabel();
		
//		GridBagLayout gridBag = new GridBagLayout();
		setLayout(new BorderLayout());

//		GridBagConstraints c = new GridBagConstraints();
//		c.gridx = 200;
//		c.ipadx = 200;
		add(troVe,BorderLayout.SOUTH);
		troVe.setHorizontalAlignment(JLabel.CENTER);
		init();
	}

	private void init() {
		Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/troVe.png").getImage()
				.getScaledInstance(301, 85, Image.SCALE_SMOOTH);
		ImageIcon img = new ImageIcon(image);
		troVe.setIcon(img);

		troVe.addMouseListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/luatChoiBackground.jpg").getImage(), 0,
				0, getWidth(), getHeight(), this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == troVe) {
			controller.showHome();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == troVe) {
			iconOdd = troVe.getIcon();
			Image image = new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/troVe.png").getImage().getScaledInstance(301,83, Image.SCALE_SMOOTH);
			ImageIcon img = new ImageIcon(image);
			troVe.setIcon(img);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == troVe) {
			troVe.setIcon(iconOdd);
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
