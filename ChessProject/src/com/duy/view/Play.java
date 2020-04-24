package com.duy.view;

import java.net.URL;
import java.util.List;

import com.duy.controller.GameController;
import com.duy.entity.Element;
import com.duy.entity.Elements;
import com.duy.entity.Point;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;

public class Play extends GridPane{
	private Button boardView[][];
	private BackgroundImage backgroundImage;
	private URL url ;
	private Image background;
	private GameController controller;
	
	public Play(GameController controller){
		boardView = new Button[5][7];
		url = getClass().getResource("/com/duy/images/");
		background  = new Image(url+"board02.jpg");
		backgroundImage = new BackgroundImage(background,BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
	
		this.controller = controller;
	}
	
	
	public void set() {
		// Extend GridPane
        setBackground(new Background(backgroundImage));
        drawBoard();
        
    	for (int i=0; i<5; i++) {
			for (int j=0; j<7; j++) {
				boardView[i][j].setOnAction(new MoveEvent(i,j,controller));
			}
		}
 
	}

	public void wayHover(List<Element> moves) {
		resetStyle();
		for (Element e: moves) {
				Point x = e.corr();
				boardView[x.getY()][x.getX()].setStyle("-fx-background-color: #69ff69;");
		}
	}
	
	public void resetStyle() {
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				boardView[j][i].setStyle("");
			}
		}
	}
	
	public void drawBoard() {
		for (int i=0; i<5; i++) {
			for (int j=0; j<7; j++) {
				boardView[i][j] = new Button();
				boardView[i][j].setMinSize(40, 40);
				if (i==0 && j==0 || i==0 && j==1|| i==1 && j==0 || i==3 && j==0 || i==4 && j==0 || i==4 && j==1 )
					continue;
				add(boardView[i][j],i+1,j+1);
				getStylesheets().add(getClass().getResource("playStyle.css").toExternalForm());
				setVgap(40);
				setHgap(25);
			}
		}
	}
	
	public void updateBoard(Elements elements) {
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				Element element = elements.getElement(new Point(i,j));
				boardView[j][i].setGraphic(new ImageView(element.getImage()));
			}
		}
	}
	
}