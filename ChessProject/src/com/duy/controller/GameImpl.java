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
	}

	@Override
	public void over() {
		// TODO Auto-generated method stub

	}

}