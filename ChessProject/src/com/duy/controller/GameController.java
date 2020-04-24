package com.duy.controller;

import java.util.List;

import com.duy.entity.BTom;
import com.duy.entity.Element;
import com.duy.entity.Elements;
import com.duy.entity.Empty;
import com.duy.entity.Hum;
import com.duy.entity.Point;
import com.duy.entity.Stop;
import com.duy.entity.Tom;
import com.duy.view.Menu;
import com.duy.view.Menu2;
import com.duy.view.Play;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameController {
	private Elements elements;
	
	private Play play;
	private Menu menu;
	private Menu2 menu2;
	
	private Stage window;
	
	private boolean isHum;
	private boolean isTwoPlayer;
	private List<Element> moves;
	private Point moveOne;
	private boolean activeFirst;
	
	public GameController(Stage window){
		elements = new Elements();
		this.window = window;
		
		activeFirst = false;
	}
	
	public void showBoard() {
		play = new Play(this);
		window.setScene(new Scene(play));
		
		play.set();
		play.updateBoard(elements);
	}
	
	public void isButtonActive(int i, int j) {
//		showGame(i,j);
		if (activeFirst == true) {
			Point x = new Point(j,i);
			System.out.println(x);
			Element buttonActive = elements.getElement(x);
			
			if (moves.contains(buttonActive)) {
				elements.move(moveOne,x);
				play.updateBoard(elements);
				checkGame();
			}
			activeFirst = false;
			
		}
		else {
			play.resetStyle();
			activeFirst = true;
			showWay(new Point(j,i));
		}
	}
	
	public void showGame(int i, int j) {
		if (isTwoPlayer) {
			showGameBi();
		}
		else {
//			showGameUni(i,j);
		}
	}
	
	public void checkGame() {
		if (elements.isGameOver() == 1) {
			System.out.println("Hum thang");
		}
		else if (elements.isGameOver() == -1){
			System.out.println("Tom thang");
		}
	}
	
	public void showGameBi() {
		System.out.println("For AI");
	}
	
	public void showWay(Point x) {
		if (elements.getElement(x) instanceof Empty || elements.getElement(x) instanceof Stop) {
			activeFirst = false;
			return;
		}
		
		if (isHum) {
			if (elements.getElement(x) instanceof Hum) {
				moveOne = x;
				moves = elements.getElement(x).movesPossible(elements.getMap());
				play.wayHover(moves);
				isHum = !isHum;
			}
			else {
				System.out.println("Luot Hum");
				activeFirst = false;
			}
		}
		else {
			if (elements.getElement(x) instanceof Tom || elements.getElement(x) instanceof BTom) {
				moveOne = x;
				moves = elements.getElement(x).movesPossible(elements.getMap());
				play.wayHover(moves);
				isHum=!isHum;
			}
			else {
				System.out.println("Luot Tom");
				activeFirst = false;
			}
		}
		
		
	}
	
	public Play getPlay() {
		return play;
	}
	
	public void showMenu() {
		menu = new Menu(this);
		window.setScene(new Scene(menu));
	}
	
	public void showMenu2() {
		menu2 = new Menu2(this);
		window.setScene(new Scene(menu2));
	}
	
	public Menu2 getMenu2() {
		return menu2;
	}

	public void setMenu2(Menu2 menu2) {
		this.menu2 = menu2;
	}

	public void setIsHum(boolean bool) {
		isHum = bool;
	}

	public Elements getElements() {
		return elements;
	}

	public void setElements(Elements elements) {
		this.elements = elements;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Stage getWindow() {
		return window;
	}

	public void setWindow(Stage window) {
		this.window = window;
	}

	public boolean isHum() {
		return isHum;
	}

	public void setHum(boolean isHum) {
		this.isHum = isHum;
	}


	public boolean isTwoPlayer() {
		return isTwoPlayer;
	}

	public void setTwoPlayer(boolean isTwoPlayer) {
		this.isTwoPlayer = isTwoPlayer;
	}

	public void setPlay(Play play) {
		this.play = play;
	}
	
}
