package application;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.net.URL;

public class Data {
	Stage window;
	URL url;
	private int squareSize = 40;
	Image chonHum,chonTom,menuBackground,Tot,BTom,Hum,background,choose,TrongSuot;
	double maxWidth = 438, maxHeight = 670;
	final int HUM=1;
    final int TOM=2;
    int player;
	boolean humMove;
	Data(Stage stage){
		window = stage;
		
		url = getClass().getResource("/application/images/");
		chonHum = new Image(url+"chonHum.png",301,85,true,true);
		chonTom = new Image(url+"chonTom.png",301,85,true,true);
		menuBackground = new Image(url+"menuBackground.png");
		
		Tot = new Image(url+"Tot01.png",squareSize,squareSize,true,true);
		BTom = new Image(url+"BTom01.png",squareSize,squareSize,true,true);
		Hum = new Image(url+"Hum02.png",squareSize,squareSize,true,true);
		background = new Image(url+"board.jpg");
		TrongSuot = new Image(url+"trongSuot.png",squareSize,squareSize,true,true);
		choose = new Image(url+"choose1.png",squareSize,squareSize,true,true);

		
	}
	
	void setPlayerHum() {
		player=HUM;
		humMove=true;
	}
	
	void setPlayerTom() {
		player=TOM;
		humMove=false;
	}
	
}
