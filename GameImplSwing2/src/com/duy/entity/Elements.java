package com.duy.entity;

import java.util.Stack;

import com.duy.utils.Constants;

public class Elements {
	
	private Stack<Element[][]> map = new Stack<>();
	private Stack<Element[][]> redo = new Stack<>();
	
	public Elements() {
		map.push(initMap());
	}

	public Element[][] getMap() {
		return map.peek();
	}

	public void setMap(Element[][] m) {
//		map.pop();
		map.push(m);
	}

	public Element[][] initMap() {
		Element[][] map = new Element[7][5];
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = new Empty(new Point(i, j));
			}
		}
		// Not board in game
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = new Stop(new Point(i,j));
			}
		}

		// Hum
		map[0][2] = new Hum(new Point(0, 2));
		map[1][1] = new Hum(new Point(1, 1));
		map[1][3] = new Hum(new Point(1, 3));

		// Tot
		
		map[1][2] = new Empty(new Point(1,2));
		
		map[3][0] = new Tom(new Point(3, 0));
		map[4][0] = new Tom(new Point(4, 0));
		map[5][0] = new Tom(new Point(5, 0));
		map[6][0] = new Tom(new Point(6, 0));

		map[3][1] = new Tom(new Point(3, 1));
		map[4][1] = new Tom(new Point(4, 1));
		map[5][1] = new Tom(new Point(5, 1));
		map[6][1] = new Tom(new Point(6, 1));

		map[3][3] = new Tom(new Point(3, 3));
		map[4][3] = new Tom(new Point(4, 3));
		map[5][3] = new Tom(new Point(5, 3));
		map[6][3] = new Tom(new Point(6, 3));

		map[3][4] = new Tom(new Point(3, 4));
		map[4][4] = new Tom(new Point(4, 4));
		map[5][4] = new Tom(new Point(5, 4));
		map[6][4] = new Tom(new Point(6, 4));

		// BTom
		map[6][2] = new BTom(new Point(6, 2));
		
		return map;
	}
	
	// Observe
	public void move(Point x, Point y) {
		
		// Swap & change map
		if (map.size()==Constants.maxStack) {
			Stack<Element[][]> tmp = new Stack<>();
			while (map.size()>1) {
				tmp.push(map.pop());
			}
			
			map.clear();
			
			while (!tmp.isEmpty()) {
				map.push(tmp.pop());
			}
		}
		
		Element[][] next = new Element[7][5];
		
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				Element tmp = map.peek()[i][j];
				next[i][j]= tmp;
			}
		}
		
		Element[][] boardData = map.peek();
		
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				if (boardData[i][j] instanceof Hum) {
					System.out.print(boardData[i][j].corr().getX()+"H"+boardData[i][j].corr().getY());
				}
				else if (boardData[i][j] instanceof BTom) {
					System.out.print(boardData[i][j].corr().getX()+"B"+boardData[i][j].corr().getY());

				}
				else if (boardData[i][j] instanceof Tom) {
					System.out.print(boardData[i][j].corr().getX()+"T"+boardData[i][j].corr().getY());
				}
				else {
					System.out.print("###");
				}
			}
			System.out.println();
		}
		
//		Element tmp = next[x.getX()][x.getY()];
		Element tmp = null;
		if (next[x.getX()][x.getY()] instanceof Hum) {
			tmp = new Hum(new Point(x.getX(),x.getY()));
		}
		if (next[x.getX()][x.getY()] instanceof Tom) {
			tmp = new Tom(new Point(x.getX(),x.getY()));
		}
		if (next[x.getX()][x.getY()] instanceof BTom) {
			tmp = new BTom(new Point(x.getX(),x.getY()));
		}
		
		tmp.setCorr(y);
		next[x.getX()][x.getY()] = new Empty(new Point(x.getX(),x.getY()));
		next[y.getX()][y.getY()] = tmp;
		
		map.push(next);
		
		boardData = map.peek();
		
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				if (boardData[i][j] instanceof Hum) {
					System.out.print(boardData[i][j].corr().getX()+"H"+boardData[i][j].corr().getY());
				}
				else if (boardData[i][j] instanceof BTom) {
					System.out.print(boardData[i][j].corr().getX()+"B"+boardData[i][j].corr().getY());

				}
				else if (boardData[i][j] instanceof Tom) {
					System.out.print(boardData[i][j].corr().getX()+"T"+boardData[i][j].corr().getY());
				}
				else {
					System.out.print("###");
				}
			}
			System.out.println();
		}
	}
	
	public void undo() {
		if (map.size()>1) {
			redo.push(map.pop());
		}
		
		
		Element[][] boardData = map.peek();
		
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				if (boardData[i][j] instanceof Hum) {
					System.out.print(boardData[i][j].corr().getX()+"H"+boardData[i][j].corr().getY());
				}
				else if (boardData[i][j] instanceof BTom) {
					System.out.print(boardData[i][j].corr().getX()+"B"+boardData[i][j].corr().getY());

				}
				else if (boardData[i][j] instanceof Tom) {
					System.out.print(boardData[i][j].corr().getX()+"T"+boardData[i][j].corr().getY());
				}
				else {
					System.out.print("###");
				}
			}
			System.out.println();
		}
	}
	
	public void redo() {
		if (!redo.isEmpty()) {
			map.push(redo.pop());
		}
	}
	
	public void updateMap(Point x, Element e) {
		Element[][] curr = map.peek();
		curr[x.getX()][x.getY()] = e;
		map.push(curr);
	}

	public Element getElement(Point x) {
		return map.peek()[x.getX()][x.getY()];
	}
	
	public int isGameOver() {
		int hum = 0;
		int tom = 0;
		int btom = 0;
		
		for (Element[] arr:map.peek()) {
			for (Element e:arr) {
				if (e instanceof Hum) {
					hum++;
				}
				
				if (e instanceof Tom) {
					tom++;
				}
				
				if (e instanceof BTom) {
					btom++;
				}
			}
		}
		
		if (hum==0) {
			return 1;
		}
		
		if (tom == 0 && btom==0) {
			return -1;
		}
		
		return 0;
	}
	
	public Elements getElement() {
		return this;
	}
	
}
