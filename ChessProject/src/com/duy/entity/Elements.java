package com.duy.entity;

public class Elements {
	private Element[][] map = new Element[5][7];

	public Elements() {
		map = new Element[7][5];
		initMap();
	}

	public Elements(Element[][] map) {
		this.map = map;
	}

	public Element[][] getMap() {
		return map;
	}

	public void setMap(Element[][] map) {
		this.map = map;
	}

	public void initMap() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = new Empty(new Point(i, j));
			}
		}
		// Not board in game
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = new Stop();
			}
		}

		// Hum
		map[0][2] = new Hum(new Point(0, 2));
		map[1][1] = new Hum(new Point(1, 1));
		map[1][3] = new Hum(new Point(1, 3));
		map[2][2] = new Hum(new Point(2, 2));
		map[1][2] = new Hum(new Point(1, 2));

		// Tot
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
	}

	public void updateMap(Point x, Element e) {
		map[x.getX()][x.getY()] = e;
	}

	public Element getElement(Point x) {
		return map[x.getX()][x.getY()];
	}
}
