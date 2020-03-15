package application;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Menu extends GridPane {
	Board board;
	Button chonHum;
	Button chonTom;
	Menu(Board board){
		this.board=board;
	}
}
