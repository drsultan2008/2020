package com.duy.controller;

import com.duy.entity.BTom;
import com.duy.entity.Element;
import com.duy.entity.Hum;
import com.duy.entity.Point;
import com.duy.entity.Tom;
import com.duy.model.ElementsManager;
import com.duy.view.BoardView;

public class GameController {
	private boolean onePlayer;
	private boolean isHum;
	private BoardView boardView;
	private ElementsManager elementsManager;
	
	public GameController(BoardView boardView){
		this.boardView = boardView;
		
		//Singleton Pattern
		elementsManager = ElementsManager.getInstance();
		elementsManager.add(boardView);
		Element[][] map = elementsManager.getElements().getMap();
		
		for (Element[] arr:map) {
			for (Element i:arr) {
				if (i instanceof Hum) {
					System.out.print("Hum");
				}
				if (i instanceof BTom) {
					System.out.print("BTom");
				}
				if (i instanceof Tom) {
					System.out.print("Tom");
				}
				else {
					System.out.print("XXX");
				}
			}
			System.out.println();
		}
	}
	
	public void setOnePlayer() {
		onePlayer = true;
		boardView.showChooseTeam();
	}
	
	public void showHome() {
		boardView.showChoosePlayer();
	}
	
	public void showLegal() {
		boardView.showLegal();
	}
	
	public void setTwoPlayer() {
		onePlayer = false;
		boardView.showChooseTeam();
	}
	
	public void setHum() {
		isHum = true;
		boardView.showPlay();
	}
	
	public void setTom() {
		isHum = false;
		boardView.showPlay();
	}
	
	public boolean getIsHum() {
		return isHum;
	}
	
	public Element[][] getMap(){
		return elementsManager.getElements().getMap();
	}
	
	public Element getElement(int i, int j) {
		return elementsManager.getElement(new Point(i,j));
	}
	
	public ElementsManager getElementManager(){
		return elementsManager;
	}
	
	public void move(Point x, Point y) {
		elementsManager.move(x, y);
	}
}
