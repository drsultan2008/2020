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
	
	private void print(Element[][] map) {
		System.out.println("========>");
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] instanceof Hum) {
					System.out.print("H");
				} else if (map[i][j] instanceof Tom) {
					System.out.print("T");
				} else if (map[i][j] instanceof BTom) {
					System.out.print("B");
				} else if (map[i][j] instanceof Empty) {
					System.out.print("O");
				} else {
					System.out.print("X");
				}
			}
			System.out.println();
		}
	}
	
	private boolean isEqual(Element[][] a, Element[][] b) {
		StringBuilder map1 = new StringBuilder();
		StringBuilder map2 = new StringBuilder();
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				if (a[i][j] instanceof Hum) {
					map1.append('H');
				} else if (a[i][j] instanceof Tom) {
					map1.append('T');
				} else if (a[i][j] instanceof BTom) {
					map1.append('B');
				} else if (a[i][j] instanceof Empty) {
					map1.append('O');
				} else {
					map1.append('X');
				}
			}
		}
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				if (b[i][j] instanceof Hum) {
					map2.append('H');
				} else if (b[i][j] instanceof Tom) {
					map2.append('T');
				} else if (b[i][j] instanceof BTom) {
					map2.append('B');
				} else if (b[i][j] instanceof Empty) {
					map2.append('O');
				} else {
					map2.append('X');
				}
			}
		}
		
		System.out.println(map1);
		System.out.println(map2);
		
		return map1.toString().equals(map2.toString());
	}
	
	public int isGameOver() {
		int hum = 0;
		int tom = 0;
		int btom = 0;
		
		Stack<Element[][]> clone = (Stack<Element[][]>) map.clone();
		
		if (clone.size()>=6) {
			Element[][] one = clone.pop();
			Element[][] two = clone.pop();
			Element[][] three = clone.pop();
			Element[][] four = clone.pop();
			Element[][] five = clone.pop();
			Element[][] six = clone.pop();
			
			
			print(one);
			print(two);
			print(three);
			print(four);
			print(five);
			print(six);
			
			if (isEqual(one,five)){
				System.out.println("====> LOOP");
				return 2;
			}
		}
		
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				if (map.peek()[i][j] instanceof Hum) {
					hum++;
				}
				
				if (map.peek()[i][j] instanceof Tom) {
					tom++;
				}
				
				if (map.peek()[i][j] instanceof BTom) {
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
