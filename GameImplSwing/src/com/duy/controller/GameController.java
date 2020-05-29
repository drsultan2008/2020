package com.duy.controller;

import com.duy.entity.BTom;
import com.duy.entity.Element;
import com.duy.entity.Hum;
import com.duy.entity.Point;
import com.duy.entity.Tom;
import com.duy.model.AIVer2;
import com.duy.model.ElementsManager;
import com.duy.view.BoardView;

public class GameController {
	private boolean onePlayer;
	private boolean isHum;
	private int aiTurn; // true - Hum 
	private BoardView boardView;
	private ElementsManager elementsManager;
	private AIVer2 ai;
	
	public GameController(BoardView boardView){
		this.boardView = boardView;
		
		//Singleton Pattern
		elementsManager = ElementsManager.getInstance();
		elementsManager.add(boardView);
		Element[][] map = elementsManager.getElements().getMap();
		ai = new AIVer2(elementsManager);
		aiTurn = 0;
		
//		for (Element[] arr:map) {
//			for (Element i:arr) {
//				if (i instanceof Hum) {
//					System.out.print("Hum");
//				}
//				if (i instanceof BTom) {
//					System.out.print("BTom");
//				}
//				if (i instanceof Tom) {
//					System.out.print("Tom");
//				}
//				else {
//					System.out.print("XXX");
//				}
//			}
//			System.out.println();
//		}
	}
	
	public void setOnePlayer() {
		onePlayer = true;
		boardView.showChooseTeam();
	}
	
	public void showHome() {
		
		//Singleton Pattern
		elementsManager.resetInstance();
		elementsManager = elementsManager.getInstance();
		boardView.showChoosePlayer();
		
		Element[][] map = elementsManager.getMap();
		elementsManager.add(boardView);
//		for (int i=0; i<7; i++) {
//			for (int j=0; j<5; j++) {
//				if (map[i][j] instanceof Hum) {
//					System.out.print("Hum");
//				}
//				else if (map[i][j] instanceof Tom) {
//					System.out.print("Tom");
//				}
//				else if (map[i][j] instanceof BTom) {
//					System.out.print("BTom");
//				}
//				else{
//					System.out.print("###");
//				}
//			}
//			System.out.println();
//		}
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
		boardView.setTurnHum();
	}
	
	public void setTom() {
		isHum = false;
		boardView.showPlay();
		boardView.setTurnTom();
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
		
//		if (isEndGame() != 0) {
//			if (isEndGame() == 1) {
////				boardView.showEndGame();
//				boardView.showEndGame();
////				endGame.setHumThang();
//			}
//			else {
//				System.out.println("Hum");
//				boardView.showEndGame();
////				boardView.showEndGame();
////				endGame.setTomThang();
//			}
//		}
	}
	
	public void setTurnHum() {
		boardView.setTurnHum();
	}
	
	public void setTurnTom() {
		boardView.setTurnTom();
	}
	
	public void undo() {
		elementsManager.undo();
		isHum=!isHum;
	}
	
	public void redo() {
		elementsManager.redo();
		isHum=!isHum;
	}
	
	public int isEndGame() {
		return elementsManager.isGameOver();
	}
	
	public void resetObserver() {
		elementsManager.reset();
	}
	
	public void showEndGame() {
		boardView.showEndGame();
		if (elementsManager.isGameOver() == 1) {
			boardView.showWinTom();
		}
		else {
			boardView.showWinHum();
		}
	}
	
	public void setTurn(int x) {
		this.aiTurn = x;
	}
	
	public void aiMove(boolean isHum) {
		ai.AIMove(elementsManager, isHum);
	}
	
	public boolean isOnePlayer() {
		return onePlayer;
	}
	
	public int getAITurn() {
		return aiTurn;
	}
}
