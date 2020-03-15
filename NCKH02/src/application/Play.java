package application;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;

public class Play extends GridPane{
	Data data;
	Play(Data data){
		this.data=data;
	}
	
	void set() {
		BackgroundImage backgroundImage = new BackgroundImage(data.background,BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));
        drawBoard();
        updateBoard();
	}

	void drawBoard() {
		
	}
	
	void updateBoard() {
		
	}
}
