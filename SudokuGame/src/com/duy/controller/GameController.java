package com.duy.controller;

import com.duy.model.BoardGame;
import com.duy.model.Node;
import com.duy.view.BoardView;

public class GameController {
	private BoardGame boardGame;
	private BoardView boardView;

	public GameController(BoardGame boardGame) {
		super();
		this.boardGame = boardGame;
	}

	public void set(BoardGame boardGame, BoardView boardView) {
		this.boardGame = boardGame;
		this.boardView = boardView;
	}

	public void readData(String path) {
		boardGame.read(path);
	}

	public void saveData(String path) {
		boardGame.save(path);
	}

	public Node getNode(int i, int j) {
		return boardGame.get(i, j);
	}

	public void setNode(int i, int j, Node node) {
		boardGame.setMap(i, j, node);
	}

	public Node[][] getMap() {
		return boardGame.getMap();
	}

	public static void main(String args[]) {
		BoardGame boardGame = new BoardGame();
		GameController gameController = new GameController(boardGame);
		BoardView boardView = new BoardView(gameController);
		// My key
		boardGame.addObserver(boardView);

		boardView.setVisible(true);
	}

}
