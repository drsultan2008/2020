package com.duy.view;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.duy.controller.GameController;
import com.duy.entity.BTom;
import com.duy.entity.Board;
import com.duy.entity.Element;
import com.duy.entity.Empty;
import com.duy.entity.Hum;
import com.duy.entity.Point;
import com.duy.entity.Stop;
import com.duy.entity.Tom;

public class OpenPanel extends JPanel implements MouseListener{
	private GameController controller;
	private List<Board> maps;
	private List<JButton> listButton;
	
	public OpenPanel(GameController controller,List<Board> maps) {
		this.controller = controller;
		this.maps = maps;
		
		listButton = new ArrayList<>();
		init();
	}
	
	private void init() {
		setLayout(new GridLayout(5,5));
		int c = 0;
		
		for (Board i:maps) {
			listButton.add(new JButton("Game "+Integer.toString(++c)));
		}

		for (JButton i:listButton) {
			add(i);
			i.addMouseListener(this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i=0; i<listButton.size(); i++) {
			if (e.getSource() == listButton.get(i)) {
				System.out.println("Value i: " + i);
				System.out.println(maps.get(i));
				
				Element[][] map = new Element[7][5];
				
				int count = 0;
				String data = maps.get(i).getData();
				
				for (int x=0; x<7; x++) {
					for (int y=0; y<5; y++) {
						char c = data.charAt(count++);
						System.out.print(c);
						if (c == 'H') {
							map[x][y] = new Hum(new Point(x,y));
						}
						else if (c == 'T') {
							map[x][y] = new Tom(new Point(x,y));
						}
						else if (c == 'B') {
							map[x][y] = new BTom(new Point(x,y));
						}
						else if (c == 'O') {
							map[x][y] = new Empty(new Point(x,y));
						}
						else {
							map[x][y] = new Stop(new Point(x,y));
						}
					}
					System.out.println();
				}
				
				System.out.println(data.charAt(34));
				System.out.println(data.charAt(35));
				
				if (data.charAt(35) == 'A') {
					controller.setOnePlayer();
				}
				
				if (data.charAt(34) == 'T') {
					controller.setTom();
				}
				else {
					controller.setHum();
				}
				
				controller.setMap(map);
				controller.showPlay();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
