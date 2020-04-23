package com.duy.controller;

import javafx.stage.Stage;

public class GameImpl implements Game {
	GameController controller;
	
	public GameImpl(Stage window){
		controller = new GameController(window);
	}
	
	@Override
	public void start() {
		controller.showMenu();
		System.out.println("IsHum: " + controller.isHum()+"," + "IsTwoPlayer: "+controller.isTwoPlayer());
	}

	@Override
	public void over() {
		// TODO Auto-generated method stub

	}

}
