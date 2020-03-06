package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;

public class Board extends GridPane{
	private RadioButton boardView[][] = new RadioButton[5][7];
	private int space = 60;
	
	Board() {
		InitBoard();
	}
	
	public void InitBoard(){
		for (int i=0; i<5; i++) {
			for (int j=0; j<7; j++) {
				boardView[i][j] = new RadioButton();
				if (i==0 && j==0 || i==0 && j==1|| i==1 && j==0 || i==3 && j==0 || i==4 && j==0 || i==4 && j==1 )
					continue;
				add(boardView[i][j],i,j);
				getStylesheets().add(getClass().getResource("boardStyle.css").toExternalForm());
				setVgap(space);
				setHgap(space);
			}
		}
	}
}
